package toolc.yourlist.remember;

import org.junit.jupiter.api.Test;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthManagerTest {

  AuthManager authManager = new AuthManager();

  @Test
  void registered_visitor_can_not_register_again() {
    var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";

    authManager.registerVisitor(uuid);
    assertThrows(IllegalArgumentException.class, () -> authManager.registerVisitor(uuid));
  }

  @Test
  void get_visitor_token_gives_Token() {
    //given
    final var uuid = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";
    authManager.registerVisitor(uuid);

    //when
    final var isPC = true;
    final var result = authManager.getVisitorToken(uuid, isPC);

    //then
    assertThat(result, is(right(new Token("accessToken", "refreshToken"))));
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
}