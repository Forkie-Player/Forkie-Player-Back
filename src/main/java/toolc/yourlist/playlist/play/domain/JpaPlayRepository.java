package toolc.yourlist.playlist.play.domain;

import toolc.yourlist.playlist.play.infra.PlayEntity;

import java.util.List;

public interface JpaPlayRepository {
  List<PlayEntity> findByPlaylistId(Long playlistId);
}
