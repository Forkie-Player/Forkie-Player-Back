package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

class EmptyMember implements AllMember {
  @Override
  public Member findByLoginId(String loginId) {
    return null;
  }

  @Override
  public Member findById(Long id) {
    return null;
  }

  @Override
  public boolean exist(Long id) {
    return false;
  }
}
