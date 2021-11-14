package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class MockPlaylistRepository implements PlaylistRepository {
  FindByMemberId findByMemberId;

  @FunctionalInterface
  public interface FindByMemberId {
    List<PlaylistEntity> done(Long memberId);
  }

  @Override
  public List<PlaylistEntity> findByMemberId(Long memberId) {
    return findByMemberId.done(memberId);
  }

  @Builder
  public MockPlaylistRepository(FindByMemberId findByMemberId) {
    this.findByMemberId = findByMemberId;
  }
}
