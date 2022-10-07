package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;
import toolc.yourlist.member.infra.Provider;

public record MemberRegisterAndLoginRequest(LoginId loginId, Password password, boolean isPC, Provider provider) {

}
