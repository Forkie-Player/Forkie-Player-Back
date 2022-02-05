package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
public class Playlists extends StreamMixIn<Playlist> {
  public Playlists(List<Playlist> list) {
    super(list);

    final int size = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }
  }
}
