package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import toolc.yourlist.playlist.domain.exception.InvalidSeqException;
import toolc.yourlist.playlist.domain.exception.NotInEqualPlaylistException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Plays{
  private final List<Play> list;

  public Plays(List<Play> list) {
    final int size = list.stream()
      .map(Play::playlistId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotInEqualPlaylistException();
    }

    list.forEach(play -> {
      if (play.sequence() != list.indexOf(play)) {
        throw new InvalidSeqException();
      }
    });

    this.list =list.stream().toList();
  }

  public <R> Stream<R> map(Function<? super Play, ? extends R> mapper) {
    return list.stream().map(mapper);
  }
}
