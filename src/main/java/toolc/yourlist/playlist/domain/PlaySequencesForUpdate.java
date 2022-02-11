package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlaySequencesForUpdate {
  private final List<PlaySequence> list;

  public PlaySequencesForUpdate(List<PlaySequence> list) {
    final int size = list.stream()
      .map(PlaySequence::sequenceToChange)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != list.size()) {
      throw new InvalidSeqException();
    }

    list.forEach(playSequence -> {
      if (0 > playSequence.sequenceToChange() || playSequence.sequenceToChange() >= list.size()) {
        throw new InvalidSeqException();
      }
    });

    this.list = list;
  }

  void forEach(Consumer<? super PlaySequence> action) {
    list.forEach(action);
  }
}
