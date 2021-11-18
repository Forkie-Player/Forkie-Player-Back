package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.domain.PlaylistJson;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlayFixture.playList;
import static toolc.yourlist.PlaylistFixture.*;

class PlaylistMapperTest {
  ThumbnailOfPlaylist thumbnailOfPlaylist;
  PlaylistMapper mapper;

  @Test
  void playlistJson로_변환() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    mapper = new PlaylistMapper(thumbnailOfPlaylist);
    PlaylistJson playlistJson = mapper.toPlaylistJson(playlist().build(), "thumbnail");

    assertThat(playlistJson, is(playlistJson().build()));
  }

  @Test
  void playlist가_null() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    mapper = new PlaylistMapper(thumbnailOfPlaylist);

    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }

  @Test
  void playlistJsonList로_변환() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> playList())
      .build());
    mapper = new PlaylistMapper(thumbnailOfPlaylist);

    List<PlaylistJson> playlistJsons = mapper.toPlaylistJsonList(playlists());

    assertThat(playlistJsons, is(playlistJsonList()));
  }
}