package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.InvalidSeqException;
import toolc.yourlist.playlist.domain.exception.NotInEqualPlaylistException;

import java.util.List;
import java.util.stream.Collectors;

public class Plays extends FirstClassCollection<Play> {
  @Override
  Long id(Play element) {
    return element.id();
  }

  public Plays(List<Play> list) {
    super(list);

    final int playlistIdCount = list.stream()
      .map(Play::playlistId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (playlistIdCount != 1) {
      throw new NotInEqualPlaylistException();
    }

    list.forEach(play -> {
      if (play.sequence() != list.indexOf(play)) {
        throw new InvalidSeqException();
      }
    });
  }
}
