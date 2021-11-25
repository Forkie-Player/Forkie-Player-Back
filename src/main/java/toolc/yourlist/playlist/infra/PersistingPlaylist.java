package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.SaveRequest;
import toolc.yourlist.playlist.domain.UpdateRequest;

public interface PersistingPlaylist {
  AllPlaylists readAllBelongsTo(String loginId);

  void saveByRequest(SaveRequest request);

  void updateTitle(Playlist playlist, UpdateRequest updateRequest);

  Playlist readBelongsTo(Long id);

  long havingCountOf(Long memberId);
}