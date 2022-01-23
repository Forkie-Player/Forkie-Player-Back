package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.infra.PlayEntity;

import java.util.List;

public interface JpaPlayRepository {
  PlayEntity save(PlayEntity playEntity);
  long countByPlaylistId(Long playlistId);
}
