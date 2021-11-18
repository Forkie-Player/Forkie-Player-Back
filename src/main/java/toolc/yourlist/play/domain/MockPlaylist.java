package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.JsonPlaylistSaveRequest;
import toolc.yourlist.play.infra.Playlist;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class MockPlaylist implements Playlist {
  ReadWhatBelongsTo readWhatBelongsTo;
  Save save;

  @Override
  public List<PlaylistEntity> readWhatBelongsTo(Long memberId) {
    return readWhatBelongsTo.done(memberId);
  }

  @Override
  public void save(PlaylistSaveRequest request) {
    save.done(request);
  }

  @FunctionalInterface
  public interface ReadWhatBelongsTo {
    List<PlaylistEntity> done(Long memberId);
  }

  @FunctionalInterface
  public interface Save {
    void done(PlaylistSaveRequest JsonPlaylistSaveRequest);
  }

  @Builder
  public MockPlaylist(ReadWhatBelongsTo readWhatBelongsTo, Save save) {
    this.readWhatBelongsTo = readWhatBelongsTo;
    this.save = save;
  }
}
