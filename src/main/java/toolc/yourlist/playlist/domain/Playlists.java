package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Playlists {
  private final List<Playlist> list;

  public Playlists(List<Playlist> list) {
    final int size = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }

    this.list = list.stream().toList();
  }

  public <R> Stream<R> map(Function<? super Playlist, ? extends R> mapper) {
    return list.stream().map(mapper);
  }
}
