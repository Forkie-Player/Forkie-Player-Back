package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public Either<String, ListOfPlaylists> belongsTo(Long memberId) {
    var member = allMember.findById(memberId);

    if (member.isEmpty()) {
      return Either.left("존재하지 않는 회원");
    }

    return Either.right(allPlaylists.readAllBelongsTo(memberId));
  }
}
