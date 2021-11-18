package toolc.yourlist.member.domain;

import lombok.Builder;

import java.util.Optional;

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
  public Member save(Member member) {
    return null;
  }

  @Builder
  public MockAllMember(FindByLoginId findByLoginId) {
    this.findByLoginId = findByLoginId;
  }
}
