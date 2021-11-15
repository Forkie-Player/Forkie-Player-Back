package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
@Component
public class MemberLogin {
  private final AllMember allMember;
  private final AccessTokenCreator accessTokenCreator;
  private final RefreshTokenCreator refreshTokenCreator;

  public Token login(LoginRequest request) {
    allMember.findByLoginId(request.loginId().raw());

    return new Token(accessTokenCreator.create(request.loginId()),
      refreshTokenCreator.create(request.device()));
  }
}
