package toolc.yourlist.playlist.infra;

import java.util.List;
import java.util.Optional;

public interface JpaPlayRepository {
  PlayEntity save(PlayEntity playEntity);

  long countByPlaylistId(Long playlistId);

  List<PlayEntity> findByPlaylistIdOrderBySequence(Long playlistId);

  Optional<PlayEntity> findById(Long id);
}
