package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AuthExpiration;
import toolc.yourlist.auth.domain.ReissueRequest;
import toolc.yourlist.auth.token.domain.TokenExpirationConfig;

@RequiredArgsConstructor
class ReissueRequestAdapterFromJson {
  private final TokenExpirationConfig tokenExpirationConfig;


  ReissueRequest mapper(JsonReissueRequest jsonRequest) {

    AuthExpiration authExpiration =
      new AuthExpiration(tokenExpirationConfig.accessTokenExpirationTime()
        , tokenExpirationConfig.refreshTokenExpirationTime(jsonRequest.isPC()));

    String tokenSavedNamePrefix = jsonRequest.isPC() ? "PC" : "APP";
    return new ReissueRequest(jsonRequest.accessToken(), jsonRequest.refreshToken(),
      authExpiration, tokenSavedNamePrefix);
  }
}
