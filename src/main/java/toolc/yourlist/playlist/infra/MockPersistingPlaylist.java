package toolc.yourlist.playlist.infra;

import lombok.Builder;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.SaveRequest;

public class MockPersistingPlaylist implements PersistingPlaylist {
  readAllBelongsTo readAllBelongsTo;
  SaveByRequest saveByRequest;
  HavingCountOf havingCountOf;
  ReadBelongsTo readBelongsTo;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    return readAllBelongsTo.done(loginId);
  }

  @FunctionalInterface
  public interface readAllBelongsTo {
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
  public void updateTitle(Playlist playlist, UpdateRequest updateRequest) {
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return readBelongsTo.done(id);
  }

  @FunctionalInterface
  public interface ReadBelongsTo {
    Playlist done(Long id);
  }

  @Builder
  public MockPersistingPlaylist(
    readAllBelongsTo readAllBelongsTo,
    SaveByRequest saveByRequest,
    HavingCountOf havingCountOf,
    ReadBelongsTo readBelongsTo) {
    this.readAllBelongsTo = readAllBelongsTo;
    this.saveByRequest = saveByRequest;
    this.havingCountOf = havingCountOf;
    this.readBelongsTo = readBelongsTo;
  }
}
