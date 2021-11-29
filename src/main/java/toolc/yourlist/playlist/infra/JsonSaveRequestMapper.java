package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonSaveRequestMapper {
  private final ReadPersisting readPersisting;
  private final MemberExistCondition memberExistCondition;
  private final SavePolicy savePolicy;

  Either<String, SaveRequest> toSaveRequest(JsonSaveRequest jsonSaveRequest) {
    var existMember = memberExistCondition.check(jsonSaveRequest.loginId());

    if (existMember.isEmpty()) {
      return left(existMember.getLeft());
    }

    var saveRequest = SaveRequest.builder()
      .loginId(jsonSaveRequest.loginId())
      .title(jsonSaveRequest.title())
      .isMember(isMember(existMember))
      .playlistCount(getPlaylistCount(existMember))
      .build();

    if (!savePolicy.matches(saveRequest)) {
      return left("[비회원] 생성 갯수 초과");
    }

    return right(saveRequest);
  }

  private long getPlaylistCount(Either<String, Member> existMember) {
    return readPersisting.havingCountOf(
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