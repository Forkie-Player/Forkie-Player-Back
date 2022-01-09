package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AllNonMember;
import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;

@RequiredArgsConstructor
public class JpaAllNonMember implements AllNonMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final NonMemberDomainAdapter adapter;

  @Override
  public NonMember findByDeviceId(String deviceId) {
    return adapter.toDomain(jpaAllMemberEntity.findByLoginId(deviceId));
  }

  @Override
  public boolean exist(String deviceId) {
    try {
      findByDeviceId(deviceId);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public NonMember save(NonMember nonMember) {
    return adapter.toDomain(
      jpaAllMemberEntity.save(
        new MemberEntity(nonMember.deviceId(), null, false)));

  }

}
