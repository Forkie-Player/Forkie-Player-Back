package toolc.yourlist.member.domain;

import lombok.Builder;

import java.util.Optional;

public class MockMemberRepository implements MemberRepository {
  FindById findById;

  @FunctionalInterface
  public interface FindById {
    Optional<Member> done(Long memberId);
  }

  @Override
  public Member findByLoginId(String loginId) {
    return null;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return findById.done(id);
  }

  @Builder
  public MockMemberRepository(FindById findById) {
    this.findById = findById;
  }
}
