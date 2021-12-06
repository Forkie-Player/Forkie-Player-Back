package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;

public interface ReadPlaylist {
  Either<String, ListOfPlaylists> belongsTo(Long memberId);
}
