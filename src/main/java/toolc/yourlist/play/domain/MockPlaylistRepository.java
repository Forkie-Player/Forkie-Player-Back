package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.Playlist;

import java.util.List;

public class MockPlaylistRepository implements PlaylistRepository {
  FindByMemberId findByMemberId;
  Save save;

  @FunctionalInterface
  public interface FindByMemberId {
    List<Playlist> done(Long memberId);
  }

  @Override
  public List<Playlist> findByMemberId(Long memberId) {
    return findByMemberId.done(memberId);
  }

  @FunctionalInterface
  public interface Save {
    Playlist done(Playlist playlist);
  }

  @Override
  public Playlist save(Playlist playlist) {
    return save.done(playlist);
  }

  @Builder
  public MockPlaylistRepository(FindByMemberId findByMemberId, Save save) {
    this.findByMemberId = findByMemberId;
    this.save = save;
  }
}
