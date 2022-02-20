package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;
import toolc.yourlist.playlist.domain.exception.NoExistPlayException;

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
    return mapper.toPlays(jpaPlayRepository.findByPlaylistIdOrderBySequence(playlistId));
  }

  @Override
  public Play belongsTo(Long id) {
    return mapper.toPlay(getEntity(id));
  }

  @Override
  @Transactional
  public void updateTime(Long id, PlayTime time) {
    var entity = getEntity(id);
    entity.time(time);
  }

  @Override
  public void updateSequence(Long id, Long sequenceToChange) {
    var entity = getEntity(id);
    entity.sequence(sequenceToChange);
  }

  @Override
  public void deleteById(Long id) {
    var entity = getEntity(id);
    jpaPlayRepository.deleteById(entity.id());
  }

  private PlayEntity getEntity(Long id) {
    return jpaPlayRepository.findById(id).orElseThrow(NoExistPlayException::new);
  }
}
