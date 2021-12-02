package toolc.yourlist.auth.domain;

public class TokenMaterialMaker {
  TokenMaterial toTokenMaterial(LoginRequest request) {
    return new TokenMaterial(request.loginId().raw(), request.device());
  }

  TokenMaterial toTokenMaterial(NonMemberLoginRequest request) {
    return new TokenMaterial(request.deviceId(), request.device());
  }
}
