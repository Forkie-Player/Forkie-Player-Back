package toolc.yourlist.member.domain;

import lombok.Builder;

import java.util.Optional;

public class MockMemberRepository implements MemberRepository {
  FindById findById;

  @FunctionalInterface
  public interface FindById {
    Optional<MemberEntity> done(Long memberId);
  }

  @Override
  public MemberEntity findByLoginId(String loginId) {
    return null;
  }

  @Override
  public Optional<MemberEntity> findById(Long id) {
    return findById.done(id);
  }

  @Builder
  public MockMemberRepository(FindById findById) {
    this.findById = findById;
  }
}
