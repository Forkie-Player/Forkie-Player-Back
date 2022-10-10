package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.infra.Provider;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberFinderTest {

  @Test
  void getInfoById(@Mock AllMember allMember) {
    var memberFinder = new MemberFinder(allMember);
    given(allMember.findInfoById(anyLong())).willReturn(new MemberInfo(
      new LoginId("george"),
      "george",
      LocalDateTime.now(),
      Provider.KAKAO));

    memberFinder.getInfoById(1L);

    verify(allMember, times(1)).findInfoById(anyLong());
    verifyNoMoreInteractions(allMember);
  }
}