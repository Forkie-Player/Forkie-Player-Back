package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.PlayEntity;

import java.util.List;

public interface PlayRepository {
  List<PlayEntity> findByPlaylistId(Long playlistId);
}
