package toolc.yourlist.playlist.domain;

import java.util.List;
import java.util.Optional;

class MockAllPlaylists implements AllPlaylists {

  @Override
  public ListOfPlaylists readAllBelongsTo(Long memberId) {
    return new ListOfPlaylists(List.of(Playlist.builder()
        .id(1L)
        .memberId(memberId)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .memberId(memberId)
        .title("Good Music")
        .thumbnail("puppy.png")
        .build()));
  }

  @Override
  public Optional<Playlist> readBelongsTo(Long id) {
    return Optional.of(Playlist.builder()
      .id(id)
      .memberId(1L)
      .title("My List")
      .thumbnail("panda.png")
      .build());
  }

  @Override
  public long havingCountOf(Long memberId) {
    return 5;
  }

  @Override
  public void save(Playlist playlist) {
  }

  @Override
  public void updateTitleBelongsTo(Long playlistId, String title) {
  }

  @Override
  public void delete(Playlist playlist) {
  }
}
