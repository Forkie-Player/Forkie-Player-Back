package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenProviderImpl implements TokenProvider{

  private final AccessTokenCreator accessTokenCreator;
  private final RefreshTokenCreator refreshTokenCreator;


  @Override
  public Token create(LoginRequest request) {
    return new Token(accessTokenCreator.create(request.loginId()),
      refreshTokenCreator.create(request.device()));
  }
}
