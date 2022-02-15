package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.NotEqualOwnerForPlaylistsException;

import java.util.List;
import java.util.stream.Collectors;

public class Playlists extends FirstClassCollection<Playlist> {
  @Override
  Long id(Playlist element) {
    return element.id();
  }

  public Playlists(List<Playlist> list) {
    super(list);

    final int memberIdCount = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (memberIdCount != 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }
  }
}
