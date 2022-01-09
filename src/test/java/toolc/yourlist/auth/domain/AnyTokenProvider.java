package toolc.yourlist.auth.domain;

class AnyTokenProvider implements TokenProvider {

  @Override
  public Token create(Long id, AuthExpiration authExpiration, String tokenSavedNamePrefix) {
    return new Token("accessToken.123", "accessToken.123");
  }
}
