package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.InfoForToken;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;


@RequiredArgsConstructor
class NonLoginRequestMapperFromJson {

  private final InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC;

  NonMemberLoginRequest mapper(JsonNonLoginRequest jsonRequest) {

    InfoForToken infoForToken = infoForTokenMakerWithIsPC.makeInfo(jsonRequest.isPC());

    return new NonMemberLoginRequest(jsonRequest.deviceId(), infoForToken);
  }
}