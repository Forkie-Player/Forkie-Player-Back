package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class UpdateRequestFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public Either<String, UpdateRequest> create(Long memberId, Long playlistId, String title) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    if (member.isEmpty()) {
      return Either.left("존재하지 않는 회원");
    }
    if (playlist.isEmpty()) {
      return Either.left("존재하지 않는 영상 목록");
    }

    return Either.right(new UpdateRequest(member.get(), playlist.get(), title));
  }
}
