package toolc.yourlist.play.domain;

import toolc.yourlist.play.infra.PlaylistEntity;

public class PlaylistMapper {
  public Playlist toPlaylistWithThumbnail(PlaylistEntity playlistEntity, String thumbnail) {
    if (playlistEntity == null) {
      throw new IllegalArgumentException();
    }

    return Playlist.builder()
      .id(playlistEntity.id())
      .thumbnail(thumbnail)
      .build();
  }
}
