package toolc.yourlist.remember;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthManagerTest {

  TokenSecretKey tokenSecretKey = new TokenSecretKey();
  AuthManager authManager = new AuthManager(
    new TokenProvider(tokenSecretKey), new TokenReader(tokenSecretKey));

  @Test
  void registered_visitor_can_not_register_again() {
    var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";

    authManager.registerVisitor(uuid);
    assertThrows(IllegalArgumentException.class, () -> authManager.registerVisitor(uuid));
  }

  @Test
  void registered_visitor_can_receive_Token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    authManager.registerVisitor(uuid);

    //when
    final var isPC = true;
    final var result = authManager.getVisitorToken(uuid, isPC);

    //then
    Long id = authManager.findIdByUUID(uuid);
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

    final var accessToken = Jwts.builder()
      .setSubject(id.toString())
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(30, ChronoUnit.MINUTES)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(7, ChronoUnit.DAYS)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    assertThat(result, is(right(new Token(accessToken, refreshToken))));
  }

  @Test
  void token_are_not_given_to_unregistered_visitor() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    assertThat(authManager.visitorsStorage.get(uuid), nullValue());

    //when
    final var isPC = true;
    final var result = authManager.getVisitorToken(uuid, isPC);
    assertThat(result, is(left("등록되어 있지 않은 방문자 입니다.")));
  }

  @Test
  void different_visitor_should_be_given_different_token() {
    //given
    final var uuid1 = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    final var uuid2 = "11ASB6JS-12QE-78DF-ZXC3-23GD22XC1V1T";
    authManager.registerVisitor(uuid1);
    authManager.registerVisitor(uuid2);
    var isPC = true;
    final var anotherVisitorToken = authManager.getVisitorToken(uuid1, isPC);

    //when
    var result = authManager.getVisitorToken(uuid2, isPC);

    //then
    assertThat(result, is(not(anotherVisitorToken)));
  }

  @Test
  void token_expiration_depending_on_connection_device() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    authManager.registerVisitor(uuid);
    final var tokenWhenConnectPc = authManager.getVisitorToken(uuid, true);

    //when
    final var tokenWhenConnectApp = authManager.getVisitorToken(uuid, false);

    //then
    assertThat(tokenWhenConnectApp, is(not(tokenWhenConnectPc)));

  }

  @Test
  void can_be_reissued_using_existing_token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    authManager.registerVisitor(uuid);
    final var token = authManager.getVisitorToken(uuid, true).get();

    //when
    final var result = authManager.reissueToken(
      token.accessToken(), token.refreshToken(), true);

    //then
    Long id = authManager.findIdByUUID(uuid);
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

    final var accessToken = Jwts.builder()
      .setSubject(id.toString())
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(30, ChronoUnit.MINUTES)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(7, ChronoUnit.DAYS)))
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
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(30, ChronoUnit.MINUTES)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(7, ChronoUnit.DAYS)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    assertThrows(IllegalArgumentException.class, () -> authManager.reissueToken(
      accessToken, refreshToken, true));
  }
}