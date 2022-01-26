package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

public record ListOfPlays(List<Play> list) {
  public ListOfPlays {
    final int size = list.stream()
      .map(Play::playlistId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new NotInEqualPlaylistException();
    }

    // 순서를 위한 로직
    // TODO: 순서 정책으로 따로 뺄 수도 있을 듯!
    list.forEach(play -> {
      if (play.sequence() != list.indexOf(play) + 1) {
        throw new InvalidSeqException();
      }
    });
  }
}
