package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

import javax.transaction.Transactional;

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
  public Plays readAllBelongsTo(Long playlistId) {
    return mapper.toListOfPlays(jpaPlayRepository.findByPlaylistIdOrderBySequence(playlistId));
  }

  @Override
  public Play belongsTo(Long id) {
    return mapper.toPlay(jpaPlayRepository.findById(id));
  }

  @Override
  @Transactional
  public void updateTime(Long id, PlayTime time) {
    var entity = getEntity(id);
    entity.time(time);
  }

  private PlayEntity getEntity(Long id) {
    return jpaPlayRepository.findById(id).orElseThrow(NoExistPlayException::new);
  }
}
