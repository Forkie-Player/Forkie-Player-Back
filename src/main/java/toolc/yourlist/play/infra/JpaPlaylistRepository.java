package toolc.yourlist.play.infra;

import java.util.List;

public interface JpaPlaylistRepository {
  List<PlaylistEntity> findByMemberId(Long memberId);

  PlaylistEntity save(PlaylistEntity playlistEntity);
}
