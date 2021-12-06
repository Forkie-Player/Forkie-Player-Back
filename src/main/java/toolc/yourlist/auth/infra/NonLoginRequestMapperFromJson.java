package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.NonMemberLoginRequest;
import toolc.yourlist.auth.token.domain.Device;

@RequiredArgsConstructor
class NonLoginRequestMapperFromJson {

  NonMemberLoginRequest mapper(JsonNonLoginRequest json) {
    Device device = json.isPC() ? Device.PC : Device.APP;
    return new NonMemberLoginRequest(json.deviceId(), device);
  }
}
