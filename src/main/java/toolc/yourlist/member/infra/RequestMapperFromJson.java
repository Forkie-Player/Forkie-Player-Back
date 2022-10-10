package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.MemberRegisterAndLoginRequest;
import toolc.yourlist.member.domain.TokenReissueRequest;
import toolc.yourlist.member.domain.VisitorRegisterAndLoginRequest;
import toolc.yourlist.member.domain.VisitorToMemberChangeRequest;
import toolc.yourlist.member.domain.loginId.LoginIdFactory;
import toolc.yourlist.member.domain.password.PasswordFactory;

@RequiredArgsConstructor
public class RequestMapperFromJson {

  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;

  VisitorRegisterAndLoginRequest mapper(JsonVisitorSignUpAndLoginRequest jsonRequest) {
    return new VisitorRegisterAndLoginRequest(jsonRequest.uuid(), jsonRequest.isPC());
  }

  MemberRegisterAndLoginRequest mapperForLocalRegister(JsonMemberSignUpAndLoginRequest jsonRequest) {
    return new MemberRegisterAndLoginRequest(
      loginIdFactory.create(jsonRequest.loginId()), passwordFactory.create(jsonRequest.password()),
      jsonRequest.isPC(), Provider.LOCAL);
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

