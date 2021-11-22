package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.PlaylistJson;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PlaylistMapper {
  private final ThumbnailOfPlaylist thumbnailOfPlaylist;

  public PlaylistJson toPlaylistJson(Playlist playlist, String thumbnail) {
    if (playlist == null) {
      throw new IllegalArgumentException();
    }

    return PlaylistJson.builder()
      .id(playlist.entity().id())
      .title(playlist.entity().title())
      .thumbnail(thumbnail)
      .build();
  }

  public List<PlaylistJson> toPlaylistJsonList(AllPlaylists allPlaylists) {
    return allPlaylists.entities()
      .stream()
      .map(playlist ->
        toPlaylistJson(playlist, thumbnailOfPlaylist.find(playlist.entity().id())))
      .collect(Collectors.toList());
  }
}