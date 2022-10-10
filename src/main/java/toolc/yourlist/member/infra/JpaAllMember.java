package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
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
  public boolean isNotExistById(Long id) {
    return jpaAllMemberEntity.findById(id).isEmpty();
  }

  @Override
  public void registerMember(LoginId loginId, Password password) {
    jpaAllMemberEntity.save(new MemberEntity(loginId.raw(), password.raw()));
  }

  @Override
  public Long findIdByLoginId(LoginId loginId) {
    return jpaAllMemberEntity.findByLoginId(loginId.raw()).get().id();
  }
}