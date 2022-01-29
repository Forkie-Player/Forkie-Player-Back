package toolc.yourlist.member.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitorAuthProviderTest {

  @Mock
  TokenProvider tokenProvider;

  @Mock
  TokenReader tokenReader;

  @Mock
  AllVisitor allVisitor;

  @InjectMocks
  VisitorAuthProvider visitorAuthProvider;

  TimeServer timeServer = new FakeTimeServer();

  @Test
  void registered_visitor_can_not_register_again() {
    var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    when(allVisitor.isNotExistByUUID(uuid))
      .thenThrow(new IllegalArgumentException());

    assertThrows(IllegalArgumentException.class, () -> visitorAuthProvider.registerVisitor(uuid));
  }

  @Test
  void registered_visitor_can_receive_Token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    visitorAuthProvider.registerVisitor(uuid);

    //when
    final var isPC = true;
    final var result = visitorAuthProvider.getVisitorToken(uuid, isPC);
    when(allVisitor.findIdByUUID(uuid)).thenReturn(3442L);

    //then
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

    Map<String, Object> payloads = new HashMap<>();
    payloads.put("Id", 3442L);
    payloads.put("UserType", UserType.MEMBER);

    final var accessToken = Jwts.builder()
      .setClaims(payloads)
      .setExpiration(Date.from(timeServer.nowTime().plus(30, ChronoUnit.MINUTES).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(timeServer.nowTime().plus(7, ChronoUnit.DAYS).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    assertThat(result, is(right(new Token(accessToken, refreshToken))));
  }

  @Test
  void token_are_not_given_to_unregistered_visitor() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    when(allVisitor.isNotExistByUUID(anyString())).thenReturn(true);

    //when
    final var isPC = true;
    final var result = visitorAuthProvider.getVisitorToken(uuid, isPC);
    assertThat(result, is(left("등록되어 있지 않은 방문자 입니다.")));
  }

  @Test
  void different_visitor_should_be_given_different_token() {
    //given
    final var uuid1 = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    final var uuid2 = "11ASB6JS-12QE-78DF-ZXC3-23GD22XC1V1T";
    final var refreshTokenExpiration = Period.ofDays(7);

    when(allVisitor.isNotExistByUUID(anyString())).thenReturn(false);
    when(allVisitor.findIdByUUID(uuid1)).thenReturn(8833L);
    when(allVisitor.findIdByUUID(uuid2)).thenReturn(99233L);
    when(tokenProvider.makeToken(8833L, refreshTokenExpiration))
      .thenReturn(new Token("access.token.8833", "refresh.token.8833"));

    //when
    final var visitorToken = visitorAuthProvider.getVisitorToken(uuid1, true);
    final var anotherVisitorToken = visitorAuthProvider.getVisitorToken(uuid2, true);

    //then
    assertThat(anotherVisitorToken, is(not(visitorToken)));
  }

  @Test
  void token_expiration_depending_on_connection_device() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    visitorAuthProvider.registerVisitor(uuid);
    final var tokenWhenConnectPc = visitorAuthProvider.getVisitorToken(uuid, true);

    //when
    final var tokenWhenConnectApp = visitorAuthProvider.getVisitorToken(uuid, false);

    //then
    assertThat(tokenWhenConnectApp, is(not(tokenWhenConnectPc)));

  }

  @Test
  void can_be_reissued_using_existing_token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    final var refreshTokenExpiration = Period.ofDays(7);
    when(allVisitor.findIdByUUID(uuid)).thenReturn(83623L);
    when(tokenProvider.makeToken(83623L, refreshTokenExpiration))
      .thenReturn(new Token("Existing.access.token.8q2e123", "Existing.refresh.token.aj2xcv3"));

    final var token = visitorAuthProvider.getVisitorToken(uuid, true).get();

    //when
    final var result = visitorAuthProvider.reissueToken(
      "Existing.access.token.8q2e123", "Existing.refresh.token.aj2xcv3", true);

    //then
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

    Map<String, Object> payloads = new HashMap<>();
    payloads.put("Id", 2444123L);
    payloads.put("UserType", UserType.MEMBER);

    final var accessToken = Jwts.builder()
      .setClaims(payloads)
      .setExpiration(Date.from(timeServer.nowTime().plus(30, ChronoUnit.MINUTES).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(timeServer.nowTime().plus(7, ChronoUnit.DAYS).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    assertThat(result, is(right(new Token(accessToken, refreshToken))));
  }

  @Test
  void should_be_registered_when_reissued() {
    String id = "4321";
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";


    final var accessToken = Jwts.builder()
      .setSubject(id)
      .setExpiration(Date.from(timeServer.nowTime().plus(30, ChronoUnit.MINUTES).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(timeServer.nowTime().plus(7, ChronoUnit.DAYS).toInstant()))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    assertThrows(IllegalArgumentException.class, () -> visitorAuthProvider.reissueToken(
      accessToken, refreshToken, true));
  }
}