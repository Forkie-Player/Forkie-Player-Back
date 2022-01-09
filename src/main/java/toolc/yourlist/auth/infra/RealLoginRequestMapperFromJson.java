package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AuthExpiration;
import toolc.yourlist.auth.domain.LoginIdFactory;
import toolc.yourlist.auth.domain.LoginRequest;
import toolc.yourlist.auth.domain.PasswordFactory;
import toolc.yourlist.auth.token.domain.TokenExpirationConfig;

@RequiredArgsConstructor
class RealLoginRequestMapperFromJson {
  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;
  private final TokenExpirationConfig tokenExpirationConfig;

  LoginRequest mapper(JsonRealLoginRequest jsonRequest) {

    AuthExpiration authExpiration =
      new AuthExpiration(tokenExpirationConfig.accessTokenExpirationTime()
        , tokenExpirationConfig.refreshTokenExpirationTime(jsonRequest.isPC()));

    String tokenSavedNamePrefix = jsonRequest.isPC() ? "PC" : "APP";

    return new LoginRequest(loginIdFactory.create(jsonRequest.loginId()),
      passwordFactory.create(jsonRequest.password()), authExpiration, tokenSavedNamePrefix);
  }
}