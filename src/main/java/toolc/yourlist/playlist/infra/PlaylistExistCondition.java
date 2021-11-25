package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class PlaylistExistCondition {
  private final PersistingPlaylist persistingPlaylist;

  Either<String, Playlist> check(Long playlistId) {
    try {
      var playlist = persistingPlaylist.readBelongsTo(playlistId);
      return right(playlist);
    } catch (IllegalArgumentException e) {
      return left(e.getMessage());
    }
  }
}
