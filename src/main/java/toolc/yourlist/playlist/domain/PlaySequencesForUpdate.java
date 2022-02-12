package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.DuplicateIdInListException;
import toolc.yourlist.playlist.domain.exception.InvalidSeqException;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlaySequencesForUpdate {
  private final List<PlaySequence> list;

  public PlaySequencesForUpdate(List<PlaySequence> list) {
    final int idCount = list.stream()
      .map(playSequence -> playSequence.validRequestForPlay().play().id())
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (idCount != list.size()) {
      throw new DuplicateIdInListException();
    }

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

    this.list =list.stream().toList();
  }

  void forEach(Consumer<? super PlaySequence> action) {
    list.forEach(action);
  }
}
