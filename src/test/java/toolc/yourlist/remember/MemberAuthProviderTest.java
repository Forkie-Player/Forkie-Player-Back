package toolc.yourlist.remember;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.control.Either.left;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberAuthProviderTest {

  @Mock
  TokenProvider tokenProvider;

  @InjectMocks
  MemberAuthProvider authProvider;


  @Test
  void registered_member_can_not_register_again() {
    //given
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("qwer1234!");


    authProvider.registerMember(loginId, password);

    assertThat(authProvider.registerMember(loginId, password), is(left("Already register Member")));

  }

  @Test
  void call_tokenProvider_once_when_request_member_login() {
    //given
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("qwer1234!");
    boolean isPC = true;
    authProvider.registerMember(loginId, password);

    //when
    System.out.println(authProvider.login(loginId, password, isPC));

    verify(tokenProvider, times(1)).makeToken(any(), any());
  }
}