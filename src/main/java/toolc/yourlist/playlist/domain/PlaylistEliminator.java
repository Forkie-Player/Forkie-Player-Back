package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistEliminator {
  private final AllPlaylists allPlaylists;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  public Either<String, Boolean> delete(DeleteRequest request) {
    if (!equalCondition.check(request.member(), request.playlist())) {
      return Either.left("Playlist 소유자의 요청이 아닙니다.");
    }

    allPlaylists.delete(request.playlist());
    return Either.right(Boolean.TRUE);
  }
}
