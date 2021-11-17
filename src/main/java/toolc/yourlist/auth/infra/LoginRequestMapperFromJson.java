package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.Device;
import toolc.yourlist.auth.domain.LoginIdFactory;
import toolc.yourlist.auth.domain.LoginRequest;
import toolc.yourlist.auth.domain.PasswordFactory;

@RequiredArgsConstructor
class LoginRequestMapperFromJson {
  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;

  LoginRequest mapper(JsonLoginRequest json) {
    Device device = json.isPC() ? Device.PC : Device.APP;

    return new LoginRequest(loginIdFactory.create(json.loginId()),
      passwordFactory.create(json.password()), device);
  }
}
