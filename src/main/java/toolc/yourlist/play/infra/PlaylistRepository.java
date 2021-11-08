package toolc.yourlist.play.infra;

import java.util.List;

public interface PlaylistRepository {
  List<PlaylistEntity> findByMemberId(Long memberId);
}
