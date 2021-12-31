package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.NoExistMemberException;

@RequiredArgsConstructor
public class AllMemberMapper implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberEntityMapper mapper = new MemberEntityMapper();

  @Override
  public Member findById(Long id) {
    return mapper.toMember(jpaAllMemberEntity.findById(id));
  }

  @Override
  public boolean exist(Long id) {
    try {
      findById(id);
      return true;
    } catch (NoExistMemberException e) {
      return false;
    }
  }
}
