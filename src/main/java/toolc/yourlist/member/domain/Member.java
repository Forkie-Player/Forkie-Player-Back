package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

record Member(LoginId loginId, Password password) {

}
