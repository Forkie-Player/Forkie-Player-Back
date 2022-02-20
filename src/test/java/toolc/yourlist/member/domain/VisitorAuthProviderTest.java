package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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

  TimeServer timeServer = new FakeTimeServer(Instant.now());

  @Test
  void registered_visitor_can_not_register_again() {
    //given
    VisitorRegisterAndLoginRequest request = new VisitorRegisterAndLoginRequest(
      "55D154BE-07E6-42FA-832B-D9CF11CE0D6A", true);


    //when
    when(allVisitor.isExistByUUID(request.uuid())).thenReturn(true);
    final var result = visitorAuthProvider.registerVisitor(request);

    //then
    assertThat(result, is(left("Already registered uuid")));
  }

  @Test
  void registered_visitor_can_receive_Token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    final var isPC = true;
    var request = new VisitorRegisterAndLoginRequest(uuid, isPC);

    //when
    when(allVisitor.findIdByUUID(uuid)).thenReturn(3912839421L);
    when(tokenProvider.makeToken(3912839421L, isPC, UserType.VISITOR))
      .thenReturn(new Token("access.token.3912839421L", "refresh.token.3912839421L"));

    //then
    final var result = visitorAuthProvider.getVisitorToken(request);

    assertThat(result, is(right(new Token(
      "access.token.3912839421L", "refresh.token.3912839421L"))));
  }

  @Test
  void token_are_not_given_to_unregistered_visitor() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    var request = new VisitorRegisterAndLoginRequest(uuid, true);
    when(allVisitor.isNotExistByUUID(anyString())).thenReturn(true);

    //when
    final var result = visitorAuthProvider.getVisitorToken(request);
    assertThat(result, is(left("Unregistered visitor")));
  }

  @Test
  void different_visitor_should_be_given_different_token() {
    //given
    final var uuid1 = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    final var uuid2 = "11ASB6JS-12QE-78DF-ZXC3-23GD22XC1V1T";
    final var isPC = true;

    when(allVisitor.isNotExistByUUID(anyString())).thenReturn(false);
    when(allVisitor.findIdByUUID(uuid1)).thenReturn(8833L);
    when(allVisitor.findIdByUUID(uuid2)).thenReturn(99233L);
    when(tokenProvider.makeToken(8833L, isPC, UserType.VISITOR))
      .thenReturn(new Token("access.token.8833", "refresh.token.8833"));

    //when
    final var visitorToken =
      visitorAuthProvider.getVisitorToken(new VisitorRegisterAndLoginRequest(uuid1, true));
    final var anotherVisitorToken =
      visitorAuthProvider.getVisitorToken(new VisitorRegisterAndLoginRequest(uuid2, true));

    //then
    assertThat(anotherVisitorToken, is(not(visitorToken)));
  }

}