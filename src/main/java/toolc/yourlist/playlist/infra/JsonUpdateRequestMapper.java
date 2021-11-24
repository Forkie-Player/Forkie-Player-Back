package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonUpdateRequestMapper {
  private final PreCondition preCondition;
  private final EqualOwnerCondition equalOwnerCondition;

  Either<String, UpdateRequest> toUpdateRequest(JsonUpdateRequest jsonUpdateRequest) {
    var existMember = preCondition.checkExistMember(jsonUpdateRequest.loginId());

    if (existMember.isEmpty()) {
      return left(existMember.getLeft());
    }

    equalOwnerCondition.check(existMember.get().entity().id(), jsonUpdateRequest.playlistId());

    return right(
      UpdateRequest.builder()
        .loginId(jsonUpdateRequest.loginId())
        .title(jsonUpdateRequest.title())
        .playlistId(jsonUpdateRequest.playlistId())
        .build());
  }
}
