package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MemberEntity;

@RequiredArgsConstructor
public class NomMemberSaveEntity {

  private final AllMember allMember;
  private final PasswordEncoder passwordEncoder;

  NonMember save(NonMember nonMember) {
    allMember.save(new MemberEntity(
      nonMember.uuid(), passwordEncoder.encode(nonMember.uuid()), false));
    return nonMember;
  }
}

