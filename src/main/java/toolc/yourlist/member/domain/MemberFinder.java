package toolc.yourlist.member.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberFinder {
  private final AllMember allMember;

  public MemberInfo getInfoById(Long id) {
    return allMember.findInfoById(id);
  }
}
