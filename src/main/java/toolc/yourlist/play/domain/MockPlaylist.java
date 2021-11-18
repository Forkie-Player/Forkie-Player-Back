package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.Playlist;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class MockPlaylist implements Playlist {
  ReadWhatBelongsTo readWhatBelongsTo;
  SaveByRequest saveByRequest;

  @Override
  public List<PlaylistEntity> readWhatBelongsTo(Long memberId) {
    return readWhatBelongsTo.done(memberId);
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    saveByRequest.done(request);
  }

  @FunctionalInterface
  public interface ReadWhatBelongsTo {
    List<PlaylistEntity> done(Long memberId);
  }

  @FunctionalInterface
  public interface SaveByRequest {
    void done(SaveRequest jsonSaveRequest);
  }

  @Builder
  public MockPlaylist(ReadWhatBelongsTo readWhatBelongsTo, SaveByRequest saveByRequest) {
    this.readWhatBelongsTo = readWhatBelongsTo;
    this.saveByRequest = saveByRequest;
  }
}
