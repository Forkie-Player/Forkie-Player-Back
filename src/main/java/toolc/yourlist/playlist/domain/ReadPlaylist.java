package toolc.yourlist.playlist.domain;

public interface ReadPlaylist {
  ListOfPlaylists allBelongsTo(Long memberId);

  Playlist belongsTo(Long id);

  long havingCountOf(Long memberId);
}
