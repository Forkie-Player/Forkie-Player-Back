package toolc.yourlist.playlist.infra;

import java.util.List;

public interface JpaPlayRepository {
  PlayEntity save(PlayEntity playEntity);

  long countByPlaylistId(Long playlistId);

  List<PlayEntity> findByPlaylistIdOrderBySequence(Long playlistId);
}
