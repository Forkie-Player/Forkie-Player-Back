package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AllPlaylistsTest {

  @Test
  void 멤버Id_불일치() {
    assertThrows(IllegalArgumentException.class, () -> new AllPlaylists(
      List.of(
        PlaylistEntity.builder()
          .memberId(1L)
          .build(),
        PlaylistEntity.builder()
          .memberId(2L)
          .build())));
  }
}