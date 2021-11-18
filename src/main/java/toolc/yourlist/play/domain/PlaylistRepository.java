package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public interface PlaylistRepository {
  List<PlaylistEntity> findByMemberId(Long memberId);

  PlaylistEntity save(PlaylistEntity playlistEntity);
}
