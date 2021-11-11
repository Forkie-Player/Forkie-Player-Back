package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.PlaylistEntity;

public class PlaylistMapper {
  public PlaylistJson toPlaylistJson(PlaylistEntity playlistEntity, String thumbnail) {
    if (playlistEntity == null) {
      throw new IllegalArgumentException();
    }

    return PlaylistJson.builder()
      .id(playlistEntity.id())
      .thumbnail(thumbnail)
      .build();
  }
}
