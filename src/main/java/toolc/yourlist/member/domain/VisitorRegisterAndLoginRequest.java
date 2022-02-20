package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

public record VisitorRegisterAndLoginRequest(String uuid, boolean isPC) {

}
