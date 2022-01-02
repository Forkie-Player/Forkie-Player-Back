package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.LoginIdFactory;
import toolc.yourlist.auth.domain.LoginRequest;
import toolc.yourlist.auth.domain.PasswordFactory;

@RequiredArgsConstructor
class RealLoginRequestMapperFromJson {
  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;

  LoginRequest mapper(JsonRealLoginRequest json) {
    return new LoginRequest(loginIdFactory.create(json.loginId()),
      passwordFactory.create(json.password()), json.isPC());
  }
}