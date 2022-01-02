package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;

@RequiredArgsConstructor
class NonLoginRequestMapperFromJson {

  NonMemberLoginRequest mapper(JsonNonLoginRequest json) {
    return new NonMemberLoginRequest(json.deviceId(), json.isPC());
  }
}