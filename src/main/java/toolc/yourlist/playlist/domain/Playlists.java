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

    final int userCodeCount = list.stream()
      .map(Playlist::userCode)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (userCodeCount > 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }
  }
}
