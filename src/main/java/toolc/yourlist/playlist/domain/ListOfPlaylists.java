package toolc.yourlist.playlist.domain;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class ListOfPlaylists {
  private final List<Playlist> entities;

  public ListOfPlaylists(List<Playlist> playlists) {
    final int size = playlists.stream()
      .map(Playlist::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new IllegalArgumentException("같은 멤버의 영상목록이 아닙니다.");
    }

    this.entities = playlists;
  }
}
