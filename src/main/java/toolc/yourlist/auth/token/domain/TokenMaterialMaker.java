package toolc.yourlist.auth.token.domain;

import toolc.yourlist.auth.domain.LoginRequest;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;

public class TokenMaterialMaker {
  public TokenMaterial toTokenMaterial(LoginRequest request) {
    return new TokenMaterial(request.loginId().raw(), request.device());
  }

  public TokenMaterial toTokenMaterial(NonMemberLoginRequest request) {
    return new TokenMaterial(request.deviceId(), request.device());
  }
}
