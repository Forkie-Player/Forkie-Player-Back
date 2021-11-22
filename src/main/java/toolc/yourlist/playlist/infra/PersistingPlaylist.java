package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.Optional;

public interface PersistingPlaylist {
  AllPlaylists readAllBelongsTo(Long memberId);

  void saveByRequest(SaveRequest request);

  void updateTitle(PlaylistEntity playlistEntity, String title);

  Optional<PlaylistEntity> readBelongsTo(Long id);
}