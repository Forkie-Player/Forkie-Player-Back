package toolc.yourlist.play.infra;

import toolc.yourlist.play.domain.PlaylistJson;

public class PlaylistMapper {
  public PlaylistJson toPlaylistJson(Playlist playlist, String thumbnail) {
    if (playlist == null) {
      throw new IllegalArgumentException();
    }

    return PlaylistJson.builder()
      .id(playlist.id())
      .title(playlist.title())
      .thumbnail(thumbnail)
      .build();
  }
}