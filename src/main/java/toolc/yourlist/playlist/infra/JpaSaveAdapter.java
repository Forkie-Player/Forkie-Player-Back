package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.SavePlaylist;

@RequiredArgsConstructor
public class JpaSaveAdapter implements SavePlaylist {
  private final JpaPlaylistRepository playlistRepository;

  @Override
  public void save(Playlist playlist) {
    playlistRepository.save(new PlaylistEntity(playlist));
  }
}
