package toolc.yourlist.playlist.domain;

public interface AllPlaylists {
  ListOfPlaylists readAllBelongsTo(Long memberId);

  Playlist readBelongsTo(Long id);

  long havingCountOf(Long memberId);

  void save(Playlist playlist);

  void updateTitle(Long memberId, String title);
}
