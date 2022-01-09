package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AuthExpiration;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;
import toolc.yourlist.auth.token.domain.TokenExpirationConfig;


@RequiredArgsConstructor
class NonLoginRequestMapperFromJson {

  private final TokenExpirationConfig tokenExpirationConfig;

  NonMemberLoginRequest mapper(JsonNonLoginRequest jsonRequest) {

    AuthExpiration authExpiration =
      new AuthExpiration(tokenExpirationConfig.accessTokenExpirationTime()
        , tokenExpirationConfig.refreshTokenExpirationTime(jsonRequest.isPC()));

    String tokenSavedNamePrefix = jsonRequest.isPC() ? "PC" : "APP";

    return new NonMemberLoginRequest(jsonRequest.deviceId(), authExpiration, tokenSavedNamePrefix);
  }
}