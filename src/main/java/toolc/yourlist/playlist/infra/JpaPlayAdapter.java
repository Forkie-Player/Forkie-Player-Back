package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlay;
import toolc.yourlist.playlist.domain.ListOfPlays;
import toolc.yourlist.playlist.domain.Play;

@RequiredArgsConstructor
public class JpaPlayAdapter implements AllPlay {
  private final JpaPlayRepository jpaPlayRepository;
  private final PlayEntityMapper mapper = new PlayEntityMapper();

  @Override
  public void save(Play play) {
    jpaPlayRepository.save(new PlayEntity(play));
  }

  @Override
  public long havingCountOf(Long playlistId) {
    return jpaPlayRepository.countByPlaylistId(playlistId);
  }

  @Override
  public ListOfPlays readAllBelongsTo(Long playlistId) {
    return mapper.toListOfPlays(jpaPlayRepository.findByPlaylistId(playlistId));
  }
}
