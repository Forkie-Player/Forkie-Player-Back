package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlay;
import toolc.yourlist.playlist.domain.JpaPlayRepository;
import toolc.yourlist.playlist.domain.Play;

@RequiredArgsConstructor
public class JpaPlayAdapter implements AllPlay {
  private final JpaPlayRepository jpaPlayRepository;

  @Override
  public void save(Play play, long playlistSize) {
    jpaPlayRepository.save(new PlayEntity(play, playlistSize + 1));
  }

  @Override
  public long havingCountOf(Long playlistId) {
    return jpaPlayRepository.countByPlaylistId(playlistId);
  }
}
