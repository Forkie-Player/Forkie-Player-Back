package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.PlaylistJson;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PlaylistMapper {
  private final ThumbnailOfPlaylist thumbnailOfPlaylist;

  public List<PlaylistJson> toPlaylistJsonList(AllPlaylists allPlaylists) {
    return allPlaylists.entities()
      .stream()
      .map(playlist ->
        PlaylistJson.builder()
          .playlist(playlist)
          .thumbnail(
            thumbnailOfPlaylist.find(playlist.id()))
          .build())
      .collect(Collectors.toList());
  }
}