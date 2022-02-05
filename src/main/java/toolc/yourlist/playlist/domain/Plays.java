package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode(callSuper = true)
public class Plays extends StreamMixIn<Play> {
  public Plays(List<Play> list) {
    super(list);
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
  }
}
