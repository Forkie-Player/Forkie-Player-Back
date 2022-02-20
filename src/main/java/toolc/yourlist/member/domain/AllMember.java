package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

public interface AllMember {
  boolean isExistByLoginId(LoginId loginId);

  boolean isNotExistById(Long id);

  void registerMember(LoginId loginId, Password password);

  Long findIdByLoginId(LoginId loginId);
}

