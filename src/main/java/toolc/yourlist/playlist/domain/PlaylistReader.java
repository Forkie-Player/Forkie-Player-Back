package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllPlaylists allPlaylists;

  public Either<String, ListOfPlaylists> belongsTo(ReadRequest request) {
    return Either.right(allPlaylists.readAllBelongsTo(request.member().id()));
  }
}
