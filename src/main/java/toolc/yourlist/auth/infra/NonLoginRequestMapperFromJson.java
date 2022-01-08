package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;

@RequiredArgsConstructor
class NonLoginRequestMapperFromJson {

  NonMemberLoginRequest mapper(JsonNonLoginRequest jsonRequest) {
    return new NonMemberLoginRequest(jsonRequest.deviceId(), jsonRequest.isPC());
  }
}