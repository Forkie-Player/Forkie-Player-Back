package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.PlaylistEntity;

public class PlaylistMapper {
  public PlaylistVO toPlaylistWithThumbnail(PlaylistEntity playlistEntity, String thumbnail) {
    if (playlistEntity == null) {
      throw new IllegalArgumentException();
    }

    return PlaylistVO.builder()
      .id(playlistEntity.id())
      .thumbnail(thumbnail)
      .build();
  }
}
