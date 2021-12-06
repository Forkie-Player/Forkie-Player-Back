package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AllNonMember;
import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.member.infra.JpaAllMemberEntity;

@RequiredArgsConstructor
public class JpaAllNonMember implements AllNonMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;

  @Override
  public NonMember findByDeviceId(String deviceId) {
    return null;
  }
}

