package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.Playlist;

import java.util.List;

public interface PlaylistRepository {
  List<Playlist> findByMemberId(Long memberId);
  Playlist save(Playlist playlist);
}
