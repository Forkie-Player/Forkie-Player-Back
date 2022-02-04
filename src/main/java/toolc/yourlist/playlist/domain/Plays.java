package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

public record Plays(List<Play> list) {
  public Plays {
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
