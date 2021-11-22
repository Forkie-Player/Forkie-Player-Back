package toolc.yourlist.playlist.infra;

import java.util.List;
import java.util.Optional;

public interface JpaPlaylistRepository {
  List<PlaylistEntity> findByMemberId(Long memberId);

  PlaylistEntity save(PlaylistEntity playlistEntity);

  Optional<PlaylistEntity> findById(Long id);

  long countByMemberId(Long memberId);
}
