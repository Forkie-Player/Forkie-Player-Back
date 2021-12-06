package toolc.yourlist.playlist.domain;

import java.util.Optional;

public interface UpdatePlaylist {
  Optional<String> updateTitle(UpdateRequest request);
}
