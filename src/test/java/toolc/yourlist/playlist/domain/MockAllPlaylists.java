package toolc.yourlist.playlist.domain;

import java.util.List;

public class MockAllPlaylists implements AllPlaylists {
  @Override
  public Playlists readAllBelongsTo(User user) {
    return new Playlists(List.of(Playlist.builder()
        .id(1L)
        .userCode(user.code())
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .userCode(user.code())
        .title("Good Music")
        .thumbnail("puppy.png")
        .build()));
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return Playlist.builder()
      .id(id)
      .userCode("MEMBER_1")
      .title("My List")
      .thumbnail("panda.png")
      .build();
  }

  @Override
  public long havingCountOf(User user) {
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

  @Override
  public void changeOwnerToMember(User visitor, User member) {

  }
}
