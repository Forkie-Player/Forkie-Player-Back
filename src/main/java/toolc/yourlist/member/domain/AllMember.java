package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;
import toolc.yourlist.member.infra.Provider;

public interface AllMember {
  boolean isExistByLoginId(LoginId loginId);

  boolean isNotExistById(Long id);

  void registerMember(LoginId loginId, Password password);

  Long findIdByLoginId(LoginId loginId);
}

