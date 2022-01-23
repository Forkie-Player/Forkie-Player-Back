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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberAuthProviderTest {

  @Mock
  TokenProvider tokenProvider;

  @Mock
  TokenReader tokenReader;

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
    authProvider.login(loginId, password, isPC);

    //then
    verify(tokenProvider, times(1)).makeToken(any(), any());
  }

  @Test
  void call_tokenProvider_once_when_request_reissue_token() {
    //given
    String accessToken = "xMiJ9.eyJJZCI6MSwiVXNlclR5cGUiOiJ2aXNpdG9yIiwQ.bVqP9ynDa";
    String refreshToken = "R5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0aWF0IjoxNTE2MjM5MDIyfQ.Sf";
    boolean isPC = true;

    authProvider.memberStorage.put(36223L, "jisoo27");
    when(tokenReader.getId(anyString())).thenReturn(36223L);

    //when
    authProvider.reissueToken(accessToken, refreshToken, isPC);

    //then
    verify(tokenProvider, times(1)).makeToken(any(), any());

  }
}