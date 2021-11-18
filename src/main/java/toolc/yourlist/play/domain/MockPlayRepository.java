package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.PlayEntity;

import java.util.List;

public final class MockPlayRepository implements PlayRepository {
  FindByPlaylistId findByPlaylistId;

  @FunctionalInterface
  public interface FindByPlaylistId {
    List<PlayEntity> done(Long playlistId);
  }

  @Override
  public List<PlayEntity> findByPlaylistId(Long playlistId) {
    return findByPlaylistId.done(playlistId);
  }

  @Builder
  public MockPlayRepository(FindByPlaylistId findByPlaylistId) {
    this.findByPlaylistId = findByPlaylistId;
  }
}
