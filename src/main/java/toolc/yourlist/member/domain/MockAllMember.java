package toolc.yourlist.member.domain;

import lombok.Builder;
import toolc.yourlist.member.infra.MemberEntity;

public class MockAllMember implements AllMember {
  FindByLoginId findByLoginId;
  FindById findById;

  @Override
  public Member findByLoginId(String loginId) {
    return findByLoginId.done(loginId);
  }

  @FunctionalInterface
  public interface FindByLoginId {
    Member done(String loginId);
  }

  @Override
  public Member findById(Long id) {
    return findById.done(id);
  }

  @FunctionalInterface
  public interface FindById {
    Member done(Long id);
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return null;
  }

  @Builder
  public MockAllMember(FindByLoginId findByLoginId, FindById findById) {
    this.findByLoginId = findByLoginId;
    this.findById = findById;
  }
}
