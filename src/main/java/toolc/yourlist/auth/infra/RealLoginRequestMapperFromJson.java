package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.*;

@RequiredArgsConstructor
class RealLoginRequestMapperFromJson {
  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;
  private final InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC;


  LoginRequest mapper(JsonRealLoginRequest jsonRequest) {

    InfoForToken infoForToken = infoForTokenMakerWithIsPC.makeInfo(jsonRequest.isPC());

    return new LoginRequest(loginIdFactory.create(jsonRequest.loginId()),
      passwordFactory.create(jsonRequest.password()), infoForToken);
  }
}