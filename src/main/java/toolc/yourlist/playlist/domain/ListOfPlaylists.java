package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.stream.Collectors;

public record ListOfPlaylists(List<Playlist> list) {
  public ListOfPlaylists {
    final int size = list.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new IllegalArgumentException("같은 멤버의 영상목록이 아닙니다.");
    }
  }
}
