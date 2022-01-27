package toolc.yourlist.member;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

public interface AllMember {
  Member isExistMember(String loginId);

  void registerMember(LoginId loginId, Password password);

  Long findIdByLoginId(LoginId loginId);
}

