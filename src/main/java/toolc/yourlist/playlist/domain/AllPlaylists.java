package toolc.yourlist.playlist.domain;

public interface AllPlaylists {
  Playlists readAllBelongsTo(User user);

  Playlist readBelongsTo(Long id);

  long havingCountOf(User user);

  void save(Playlist playlist);

  void updateTitleBelongsTo(Long playlistId, String title);

  void delete(Playlist playlist);

  void updateThumbnail(Long playlistId, String thumbnail);

  void changeOwnerToMember(User visitor, User member);
}
