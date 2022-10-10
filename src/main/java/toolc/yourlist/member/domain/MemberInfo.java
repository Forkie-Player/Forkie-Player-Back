package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.infra.Provider;

import java.time.LocalDateTime;

public record MemberInfo(LoginId loginId, String nickname, LocalDateTime createdAt, Provider provider) {
}
