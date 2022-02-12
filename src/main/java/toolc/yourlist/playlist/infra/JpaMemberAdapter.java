package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.exception.NoExistMemberException;

@RequiredArgsConstructor
public class JpaMemberAdapter implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberEntityMapper mapper = new MemberEntityMapper();

  @Override
  public Member findById(Long id) {
    return mapper.toMember(getEntity(id));
  }

  @Override
  public boolean exist(Long id) {
    try {
      getEntity(id);
      return true;
    } catch (NoExistMemberException e) {
      return false;
    }
  }

  private MemberEntity getEntity(Long id) {
    return jpaAllMemberEntity.findById(id).orElseThrow(NoExistMemberException::new);
  }
}
