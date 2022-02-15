package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.InvalidSeqException;

import java.util.List;
import java.util.stream.Collectors;

public class PlaySequencesForUpdate extends FirstClassCollection<PlaySequence> {
  @Override
  Long id(PlaySequence element) {
    return element.validRequestForPlay().play().id();
  }

  public PlaySequencesForUpdate(List<PlaySequence> list) {
    super(list);

    final int sequenceCount = list.stream()
      .map(PlaySequence::sequenceToChange)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (sequenceCount != list.size()) {
      throw new InvalidSeqException();
    }

    list.forEach(playSequence -> {
      if (0 > playSequence.sequenceToChange() || playSequence.sequenceToChange() >= list.size()) {
        throw new InvalidSeqException();
      }
    });
  }
}
