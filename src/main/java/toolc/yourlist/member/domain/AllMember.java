package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;
import toolc.yourlist.member.infra.Provider;

public interface AllMember {
  boolean isExistByLoginId(LoginId loginId);

  boolean isExistByNickname(String nickname);

  void registerMember(LoginId loginId, Password password, String nickname, Provider provider);

  MemberInfo findInfoById(Long id);

  Long findIdByLoginId(LoginId loginId);

  Long countContainNickname(String nickname);

  void editNickname(Long id, String nickname);
}

