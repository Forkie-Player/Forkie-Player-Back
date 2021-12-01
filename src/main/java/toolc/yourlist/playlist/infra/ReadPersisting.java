package toolc.yourlist.playlist.infra;

import toolc.yourlist.auth.domain.LoginId2;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

interface ReadPersisting {
  AllPlaylists readAllBelongsTo(LoginId2 loginId);

  Playlist readBelongsTo(Long id);

  long havingCountOf(Long memberId);
}
