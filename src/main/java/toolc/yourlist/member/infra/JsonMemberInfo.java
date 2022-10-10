package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.MemberInfo;

import java.time.LocalDateTime;

public record JsonMemberInfo(String loginId, String nickname, LocalDateTime createdAt, Provider provider) {
  public JsonMemberInfo(MemberInfo memberInfo) {
    this(
      memberInfo.loginId().raw(),
      memberInfo.nickname(),
      memberInfo.createdAt(),
      memberInfo.provider());
  }
}
