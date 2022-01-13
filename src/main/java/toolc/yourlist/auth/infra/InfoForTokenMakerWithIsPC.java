package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AuthExpiration;
import toolc.yourlist.auth.domain.InfoForToken;
import toolc.yourlist.auth.token.domain.TokenExpirationConfig;

@RequiredArgsConstructor
class InfoForTokenMakerWithIsPC {
  private final TokenExpirationConfig tokenExpirationConfig;

  InfoForToken makeInfo(boolean isPC) {
    AuthExpiration authExpiration =
      new AuthExpiration(tokenExpirationConfig.accessTokenExpirationTime()
        , tokenExpirationConfig.refreshTokenExpirationTime(isPC));

    String tokenSavedNamePrefix = isPC ? "PC" : "APP";

    return new InfoForToken(authExpiration, tokenSavedNamePrefix);
  }
}
