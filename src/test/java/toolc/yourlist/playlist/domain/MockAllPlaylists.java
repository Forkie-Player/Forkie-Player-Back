package toolc.yourlist.playlist.domain;

import java.util.List;

public class MockAllPlaylists implements AllPlaylists {

  @Override
  public Playlists readAllBelongsTo(Long memberId) {
    return new Playlists(List.of(Playlist.builder()
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
  public Playlist readBelongsTo(Long id) {
    return Playlist.builder()
      .id(id)
      .memberId(1L)
      .title("My List")
      .thumbnail("panda.png")
      .build();
  }

  @Override
  public boolean exist(Long id) {
    return true;
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

  @Override
  public void updateThumbnail(Long playlistId, String thumbnail) {
  }
}
