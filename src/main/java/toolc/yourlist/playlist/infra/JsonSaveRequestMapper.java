package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class JsonSaveRequestMapper {
  private final ReadPersisting readPersisting;
  private final AllMember allMember;
  private final SavePolicy savePolicy;

  Either<String, SaveRequest> toSaveRequest(JsonSaveRequest jsonSaveRequest) {
    try {
      var existMember = allMember.findByLoginId(jsonSaveRequest.loginId());
      var saveRequest = getSaveRequest(jsonSaveRequest, existMember);

      if (!savePolicy.matches(saveRequest)) {
        return left("[비회원] 생성 갯수 초과"); // TODO: 이건 여기 있을게 아닌 듯... 내용에 관한 거니까..
      }

      return right(saveRequest);
    } catch (Exception e) {
      return left(e.getMessage());
    }
  }

  private SaveRequest getSaveRequest(JsonSaveRequest jsonSaveRequest, Member existMember) {
    return SaveRequest.builder()
      .loginId(jsonSaveRequest.loginId())
      .title(jsonSaveRequest.title())
      .isMember(existMember.isMember())
      .playlistCount(getPlaylistCount(existMember))
      .build();
  }

  private long getPlaylistCount(Member member) {
    return readPersisting.havingCountOf(member.id());
  }
}