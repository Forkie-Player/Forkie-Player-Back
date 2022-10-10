package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.*;
import toolc.yourlist.member.domain.loginId.LoginIdFactory;
import toolc.yourlist.member.domain.password.PasswordFactory;

@RequiredArgsConstructor
public class RequestMapperFromJson {

  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;

  VisitorRegisterAndLoginRequest mapper(JsonVisitorSignUpAndLoginRequest jsonRequest) {
    return new VisitorRegisterAndLoginRequest(jsonRequest.uuid(), jsonRequest.isPC());
  }

  MemberRegisterAndLoginRequest mapper(JsonMemberSignUpAndLoginRequest jsonRequest) {
    return new MemberRegisterAndLoginRequest(
      loginIdFactory.create(jsonRequest.loginId()), passwordFactory.create(jsonRequest.password()),
      jsonRequest.isPC());
  }

  TokenReissueRequest mapper(JsonTokenReissueRequest jsonRequest) {
    return new TokenReissueRequest(
      jsonRequest.accessToken(), jsonRequest.refreshToken(), jsonRequest.isPC());
  }

  VisitorToMemberChangeRequest mapper(JsonVisitorToMemberChangeRequest jsonRequest) {
    return new VisitorToMemberChangeRequest(
      jsonRequest.uuid(),
      loginIdFactory.create(jsonRequest.loginId()),
      passwordFactory.create(jsonRequest.password()),
      jsonRequest.isPC());
  }

}

