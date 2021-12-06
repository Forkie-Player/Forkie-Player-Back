package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.common.domain.ContractViolationException;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.ReadPlaylist;

@RequiredArgsConstructor
class PlaylistReader implements ReadPlaylist {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  @Override
  public Either<String, ListOfPlaylists> belongsTo(Long memberId) {
    try {
      var member = allMember.findById(memberId);

      return Either.right(allPlaylists.readAllBelongsTo(memberId));
    } catch (ContractViolationException e) {
      return Either.left(e.getMessage());
    }
  }
}
