package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

record PlaySequencesForUpdate(List<PlaySequence> list) {
  public PlaySequencesForUpdate {
    final int size = list.stream()
      .map(PlaySequence::sequenceToChange)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != list.size()) {
      throw new InvalidSeqException();
    }

    list.forEach(playSequence -> {
      if (1 > playSequence.sequenceToChange() || playSequence.sequenceToChange() > list.size()) {
        throw new InvalidSeqException();
      }
    });
  }
}
