package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class JpaUpdateAdapter implements UpdatePersisting {
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
