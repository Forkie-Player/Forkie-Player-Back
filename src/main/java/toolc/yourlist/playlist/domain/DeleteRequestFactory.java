package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteRequestFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public Either<String, DeleteRequest> create(Long memberId, Long playlistId) {
    if (!allMember.exist(memberId)) {
      return Either.left("존재하지 않는 회원");
    }
    if (!allPlaylists.exist(playlistId)) {
      return Either.left("존재하지 않는 영상 목록");
    }

    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return Either.right(new DeleteRequest(member, playlist));
  }
}
