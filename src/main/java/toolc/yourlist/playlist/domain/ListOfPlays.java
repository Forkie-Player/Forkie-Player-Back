package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

// TODO: Play들의 순서 보장 로직 필요
public record ListOfPlays(List<Play> list) {
  public ListOfPlays {
    final int size = list.stream()
      .map(Play::playlistId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotInEqualPlaylistException();
    }

    // 순서 중복 검증
    final int seqSize = list.stream()
      .map(Play::sequence)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (seqSize != list.size()) {
      throw new DuplicateSeqException();
    }
  }
}
