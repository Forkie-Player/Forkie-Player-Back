package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

public record Playlists(List<Playlist> list) {
  public Playlists {
    final int size = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }
  }
}
