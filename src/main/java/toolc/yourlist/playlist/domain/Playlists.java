package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import toolc.yourlist.playlist.domain.exception.DuplicateIdInListException;
import toolc.yourlist.playlist.domain.exception.NotEqualOwnerForPlaylistsException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Playlists {
  private final List<Playlist> list;

  public Playlists(List<Playlist> list) {
    final int idCount = list.stream()
      .map(Playlist::id)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (idCount != list.size()) {
      throw new DuplicateIdInListException();
    }

    final int memberIdCount = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (memberIdCount != 1) {
      throw new NotEqualOwnerForPlaylistsException();
    }

    this.list = list.stream().toList();
  }

  public <R> Stream<R> map(Function<? super Playlist, ? extends R> mapper) {
    return list.stream().map(mapper);
  }
}
