package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

interface ReadPersisting {
  AllPlaylists readAllBelongsTo(Long memberId);

  Playlist readBelongsTo(Long id);

  long havingCountOf(Long memberId);
}
