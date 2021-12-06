package toolc.yourlist.playlist.domain;

import java.util.Optional;

public interface CreatePlaylist {
  Optional<String> createPlaylist(Long memberId, String title);
}
