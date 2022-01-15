package toolc.yourlist.remember;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

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

    final var isPC = true;
    final var token = authManager.getVisitorToken(uuid, isPC);

    assertThat(token, is(new Token("accessToken", "refreshToken")));
  }
}