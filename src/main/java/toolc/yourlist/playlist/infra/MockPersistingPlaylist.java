package toolc.yourlist.playlist.infra;

import lombok.Builder;
import toolc.yourlist.playlist.domain.SaveRequest;
import toolc.yourlist.playlist.infra.AllPlaylists;
import toolc.yourlist.playlist.infra.PersistingPlaylist;
import toolc.yourlist.playlist.infra.PlaylistEntity;

import java.util.List;
import java.util.Optional;

public class MockPersistingPlaylist implements PersistingPlaylist {
  ReadWhatBelongsTo readWhatBelongsTo;
  SaveByRequest saveByRequest;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    return readWhatBelongsTo.done(loginId);
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    saveByRequest.done(request);
  }

  @FunctionalInterface
  public interface ReadWhatBelongsTo {
    AllPlaylists done(String loginId);
  }

  @FunctionalInterface
  public interface SaveByRequest {
    void done(SaveRequest jsonSaveRequest);
  }

  @Override
  public void updateTitle(Playlist playlist, String title) {
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return null;
  }

  @Builder
  public MockPersistingPlaylist(ReadWhatBelongsTo readWhatBelongsTo, SaveByRequest saveByRequest) {
    this.readWhatBelongsTo = readWhatBelongsTo;
    this.saveByRequest = saveByRequest;
  }
}
