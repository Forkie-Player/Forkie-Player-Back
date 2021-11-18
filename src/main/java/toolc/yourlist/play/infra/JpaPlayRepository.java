package toolc.yourlist.play.infra;

import java.util.List;

public interface JpaPlayRepository {
  List<PlayEntity> findByPlaylistId(Long playlistId);
}
