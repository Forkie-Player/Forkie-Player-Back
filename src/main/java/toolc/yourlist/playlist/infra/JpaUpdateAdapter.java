package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.UpdatePlaylist;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class JpaUpdateAdapter implements UpdatePlaylist {
  private final JpaPlaylistRepository playlistRepository;

  @Override
  @Transactional
  public void updateTitle(Long playlistId, String title) {
    PlaylistEntity entity = playlistRepository
      .findById(playlistId)
      .orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 영상 목록입니다."));

    entity.title(title);
  }
}
