package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.playlist.domain.SaveRequest;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonSaveRequestMapper {
  private final PersistingPlaylist persistingPlaylist;
  private final PreCondition preCondition;

  Either<String, SaveRequest> toSaveRequest(JsonSaveRequest jsonSaveRequest) {
    var existMember = preCondition.checkExistMember(jsonSaveRequest.loginId());

    if (existMember.isEmpty()) {
      return left(existMember.getLeft());
    }

    return right(
      SaveRequest.builder()
        .loginId(jsonSaveRequest.loginId())
        .title(jsonSaveRequest.title())
        .isMember(isMember(existMember))
        .playlistCount(getPlaylistCount(existMember))
        .build());
  }

  private long getPlaylistCount(Either<String, Member> existMember) {
    return persistingPlaylist.havingCountOf(
      existMember
        .get()
        .entity()
        .id());
  }

  private boolean isMember(Either<String, Member> existMember) {
    return existMember
      .get()
      .entity()
      .isMember();
  }
}