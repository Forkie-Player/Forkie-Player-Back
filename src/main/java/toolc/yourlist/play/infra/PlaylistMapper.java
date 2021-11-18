package toolc.yourlist.play.infra;

import toolc.yourlist.play.domain.PlaylistJson;

public class PlaylistMapper {
  public PlaylistJson toPlaylistJson(PlaylistEntity playlistEntity, String thumbnail) {
    if (playlistEntity == null) {
      throw new IllegalArgumentException();
    }

    return PlaylistJson.builder()
      .id(playlistEntity.id())
      .title(playlistEntity.title())
      .thumbnail(thumbnail)
      .build();
  }
}