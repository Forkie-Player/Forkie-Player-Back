package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class MockPlaylistRepository implements PlaylistRepository {
  FindByMemberId findByMemberId;
  Save save;

  @FunctionalInterface
  public interface FindByMemberId {
    List<PlaylistEntity> done(Long memberId);
  }

  @Override
  public List<PlaylistEntity> findByMemberId(Long memberId) {
    return findByMemberId.done(memberId);
  }

  @FunctionalInterface
  public interface Save {
    PlaylistEntity done(PlaylistEntity playlistEntity);
  }

  @Override
  public PlaylistEntity save(PlaylistEntity playlistEntity) {
    return save.done(playlistEntity);
  }

  @Builder
  public MockPlaylistRepository(FindByMemberId findByMemberId, Save save) {
    this.findByMemberId = findByMemberId;
    this.save = save;
  }
}
