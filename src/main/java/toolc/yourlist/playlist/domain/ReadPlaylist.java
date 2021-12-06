package toolc.yourlist.playlist.domain;

public interface ReadPlaylist {
  ListOfPlaylists belongsTo(Long memberId);
}
