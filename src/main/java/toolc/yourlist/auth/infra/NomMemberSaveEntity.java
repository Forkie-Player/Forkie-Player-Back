package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.auth.domain.NonMemberSave;
import toolc.yourlist.auth.domain.PasswordEncoder;
import toolc.yourlist.member.infra.AllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;

@RequiredArgsConstructor
public class NomMemberSaveEntity implements NonMemberSave {

  private final AllMemberEntity allMemberEntity;
  private final PasswordEncoder passwordEncoder;

  @Override
  public NonMember save(NonMember nonMember) {
    allMemberEntity.save(new MemberEntity(
      nonMember.deviceId(), passwordEncoder.encode(nonMember.deviceId()), false));
    return nonMember;
  }
}

