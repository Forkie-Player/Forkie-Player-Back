package toolc.yourlist.playlist.domain;

import java.util.Optional;

class MockAllPlaylists implements AllPlaylists {
  @Override
  public ListOfPlaylists readAllBelongsTo(Long memberId) {
    return null;
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
    return 0;
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
