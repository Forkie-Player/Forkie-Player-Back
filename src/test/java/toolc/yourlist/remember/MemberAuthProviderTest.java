package toolc.yourlist.remember;

import org.junit.jupiter.api.Test;

import static io.vavr.control.Either.left;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MemberAuthProviderTest {

  MemberAuthProvider authProvider = new MemberAuthProvider();


  @Test
  void registered_member_can_not_register_again() {
    //given
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("qwer1234!");


    authProvider.registerMember(loginId, password);

    assertThat(authProvider.registerMember(loginId, password), is(left("Already register Member")));

  }
}