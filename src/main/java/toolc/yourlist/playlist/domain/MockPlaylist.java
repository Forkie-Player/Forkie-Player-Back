package toolc.yourlist.playlist.domain;

import lombok.Builder;
import toolc.yourlist.playlist.infra.Playlist;
import toolc.yourlist.playlist.infra.PlaylistEntity;

import java.util.List;
import java.util.Optional;

public class MockPlaylist implements Playlist {
  ReadWhatBelongsTo readWhatBelongsTo;
  SaveByRequest saveByRequest;

  @Override
  public List<PlaylistEntity> readAllBelongsTo(Long memberId) {
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

  @Override
  public void updateTitle(PlaylistEntity playlistEntity, String title) {

  }

  @Override
  public Optional<PlaylistEntity> readBelongsTo(Long id) {
    return null;
  }

  @Builder
  public MockPlaylist(ReadWhatBelongsTo readWhatBelongsTo, SaveByRequest saveByRequest) {
    this.readWhatBelongsTo = readWhatBelongsTo;
    this.saveByRequest = saveByRequest;
  }
}
