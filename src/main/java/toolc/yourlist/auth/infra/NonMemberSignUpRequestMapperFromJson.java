package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.NonMemberSignUpRequest;

class NonMemberSignUpRequestMapperFromJson {
  NonMemberSignUpRequest mapper(JsonNonMemberSignUpRequest json) {
    return new NonMemberSignUpRequest(json.deviceId());
  }
}
