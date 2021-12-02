package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class MemberCondition {
  private final AllMember allMember;

  boolean checkRealMember(Long memberId) {
    var member = allMember.findById(memberId);
    return member.isMember();
  }

  boolean checkNonMember(Long memberId) {
    var member = allMember.findById(memberId);
    return !member.isMember();
  }
}
