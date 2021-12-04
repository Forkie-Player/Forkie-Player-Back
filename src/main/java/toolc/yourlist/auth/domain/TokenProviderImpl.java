package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenProviderImpl implements TokenProvider{

  private final AccessTokenCreator accessTokenCreator;
  private final RefreshTokenCreator refreshTokenCreator;


  @Override
  public Token create(TokenMaterial tokenMaterial) {
    return new Token(accessTokenCreator.create(tokenMaterial.identifier()),
      refreshTokenCreator.create(tokenMaterial.device()));
  }
}
