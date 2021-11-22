package toolc.yourlist.playlist.infra;

import lombok.Builder;
import toolc.yourlist.playlist.domain.SaveRequest;

public class MockPersistingPlaylist implements PersistingPlaylist {
  ReadWhatBelongsTo readWhatBelongsTo;
  SaveByRequest saveByRequest;
  HavingCountOf havingCountOf;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    return readWhatBelongsTo.done(loginId);
  }

  @FunctionalInterface
  public interface ReadWhatBelongsTo {
    AllPlaylists done(String loginId);
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    saveByRequest.done(request);
  }


  @FunctionalInterface
  public interface SaveByRequest {
    void done(SaveRequest jsonSaveRequest);
  }

  @Override
  public long havingCountOf(Long memberId) {
    return havingCountOf.done();
  }

  @FunctionalInterface
  public interface HavingCountOf {
    long done();
  }

  @Override
  public void updateTitle(Playlist playlist, String title) {
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return null;
  }

  @Builder
  public MockPersistingPlaylist(
    ReadWhatBelongsTo readWhatBelongsTo,
    SaveByRequest saveByRequest,
    HavingCountOf havingCountOf) {
    this.readWhatBelongsTo = readWhatBelongsTo;
    this.saveByRequest = saveByRequest;
    this.havingCountOf = havingCountOf;
  }
}
