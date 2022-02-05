package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.VisitorRegisterRequest;

public class RequestMapperFromJson {

  VisitorRegisterRequest mapper(JsonVisitorSignUpAndLoginRequest jsonRequest) {
    return new VisitorRegisterRequest(jsonRequest.uuid(), jsonRequest.isPC());
  }
}
