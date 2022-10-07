package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MemberInfo;
import toolc.yourlist.member.domain.NotExistMemberException;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

@RequiredArgsConstructor
class JpaAllMember implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberEntityToDomainAdapter memberEntityToDomainAdapter;

  @Override
  public boolean isExistByLoginId(LoginId loginId) {
    return jpaAllMemberEntity.findByLoginId(loginId.raw()).isPresent();
  }

  @Override
  public void registerMember(LoginId loginId, Password password, String nickname, Provider provider) {
    jpaAllMemberEntity.save(MemberEntity.builder()
      .loginId(loginId.raw())
      .password(password.raw())
      .nickname(nickname)
      .provider(provider)
      .build());
  }

  @Override
  public MemberInfo findInfoById(Long id) {
    var memberEntity = jpaAllMemberEntity.findById(id).orElseThrow(NotExistMemberException::new);

    return convertMemberInfo(memberEntity);
  }

  @Override
  public Long findIdByLoginId(LoginId loginId) {
    return jpaAllMemberEntity.findByLoginId(loginId.raw()).get().id();
  }

  @Override
  public Long countContainNickname(String nickname) {
    return jpaAllMemberEntity.countContainNickname(nickname);
  }

  private MemberInfo convertMemberInfo(MemberEntity memberEntity) {
    return new MemberInfo(
      new LoginId(memberEntity.loginId()),
      memberEntity.nickname(),
      memberEntity.createdAt(),
      memberEntity.provider());
  }
}