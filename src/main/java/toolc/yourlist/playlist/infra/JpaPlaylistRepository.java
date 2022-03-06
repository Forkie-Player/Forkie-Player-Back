package toolc.yourlist.playlist.infra;

import java.util.List;
import java.util.Optional;

interface JpaPlaylistRepository {
  List<PlaylistEntity> findByUserCode(String userCode);

  PlaylistEntity save(PlaylistEntity playlistEntity);

  Optional<PlaylistEntity> findById(Long id);

  long countByUserCode(String userCode);

  void deleteById(Long id);
}
