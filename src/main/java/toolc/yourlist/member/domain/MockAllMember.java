package toolc.yourlist.member.domain;

import lombok.Builder;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;

public class MockAllMember implements AllMember {
  FindByLoginId findByLoginId;

  @FunctionalInterface
  public interface FindByLoginId {
   Member done(String loginId);
  }

  @Override
  public Member findByLoginId(String loginId) {
    return findByLoginId.done(loginId);
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return null;
  }

  @Builder
  public MockAllMember(FindByLoginId findByLoginId) {
    this.findByLoginId = findByLoginId;
  }
}
