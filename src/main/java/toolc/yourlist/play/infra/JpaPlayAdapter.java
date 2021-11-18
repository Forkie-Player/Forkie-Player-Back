package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JpaPlayAdapter implements Play {
  private final JpaPlayRepository playRepository;

  @Override
  public List<PlayEntity> readWhatBelongsTo(Long playlistId) {
    return playRepository.findByPlaylistId(playlistId);
  }
}
