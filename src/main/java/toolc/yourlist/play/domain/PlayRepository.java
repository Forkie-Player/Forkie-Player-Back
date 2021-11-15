package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.Play;

import java.util.List;

public interface PlayRepository {
  List<Play> findByPlaylistId(Long playlistId);
}
