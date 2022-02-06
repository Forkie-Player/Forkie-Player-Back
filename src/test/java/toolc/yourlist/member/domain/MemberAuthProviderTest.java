package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

import static io.vavr.control.Either.left;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberAuthProviderTest {

  @Mock
  TokenProvider tokenProvider;

  @Mock
  AllMember allMember;

  @Mock
  TokenReader tokenReader;

  @InjectMocks
  MemberAuthProvider authProvider;


  @Test
  void registered_member_can_not_register_again() {
    //given
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("qwer1234!");
    boolean isPC = true;
    var request = new MemberRegisterAndLoginRequest(loginId, password, isPC);

    when(allMember.isExistByLoginId(loginId)).thenReturn(true);

    //then
    assertThat(authProvider.registerMember(request), is(left("Already register Member")));
  }

  @Test
  void call_tokenProvider_once_when_request_member_login() {
    //given
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("qwer1234!");
    boolean isPC = true;
    var request = new MemberRegisterAndLoginRequest(loginId, password, isPC);

    //when
    authProvider.getMemberToken(request);

    //then
    verify(tokenProvider, times(1)).makeToken(any(), any(), any());
  }

}