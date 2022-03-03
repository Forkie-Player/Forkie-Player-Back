package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

public record VisitorToMemberChangeRequest(String uuid, LoginId loginId, Password password,
                                           boolean isPC) {

}
