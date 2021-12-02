package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
public class JpaSaveAdapter implements SavePersisting {
  private final JpaPlaylistRepository playlistRepository;

  @Override
  public void save(Playlist playlist) {
    playlistRepository.save(new PlaylistEntity(playlist));
  }
}
