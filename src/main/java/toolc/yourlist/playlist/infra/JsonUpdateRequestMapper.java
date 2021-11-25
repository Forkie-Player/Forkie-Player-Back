package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonUpdateRequestMapper {
  private final MemberExistCondition memberExistCondition;
  private final EqualOwnerCondition equalOwnerCondition;
  private final PlaylistExistCondition playlistExistCondition;

  Either<String, UpdateRequest> toUpdateRequest(JsonUpdateRequest jsonUpdateRequest) {
    var existMember = memberExistCondition.check(jsonUpdateRequest.loginId());
    if (existMember.isEmpty()) {
      return left(existMember.getLeft());
    }

    var existPlaylist = playlistExistCondition.check(jsonUpdateRequest.playlistId());
    if (existPlaylist.isEmpty()) {
      return left(existPlaylist.getLeft());
    }

    if (!equalOwnerCondition.check(
      existMember.get(),
      existPlaylist.get())) {
      return left("영상목록의 주인이 아닙니다.");
    }

    return right(
      UpdateRequest.builder()
        .member(existMember.get())
        .title(jsonUpdateRequest.title())
        .playlistId(jsonUpdateRequest.playlistId())
        .build());
  }
}
