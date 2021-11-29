package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonUpdateRequestMapper {
  private final AllMember allMember;
  private final EqualOwnerCondition equalOwnerCondition;
  private final ReadPersisting readPersisting;

  Either<String, UpdateRequest> toUpdateRequest(JsonUpdateRequest jsonUpdateRequest) {
    try {
      var existMember = allMember.findByLoginId(jsonUpdateRequest.loginId());
      var existPlaylist = readPersisting.readBelongsTo(jsonUpdateRequest.playlistId());

      if (!equalOwnerCondition.check(existMember, existPlaylist)) { // TODO: 이것도 여기 있을 것이 아닌 듯...
        return left("영상목록의 주인이 아닙니다.");
      }
      return right(getUpdateRequest(jsonUpdateRequest, existMember));
    } catch (Exception e) {
      return left(e.getMessage());
    }
  }

  private UpdateRequest getUpdateRequest(JsonUpdateRequest jsonUpdateRequest, Member existMember) {
    return UpdateRequest.builder()
      .member(existMember)
      .title(jsonUpdateRequest.title())
      .playlistId(jsonUpdateRequest.playlistId())
      .build();
  }
}
