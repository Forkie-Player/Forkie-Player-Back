package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.common.domain.Result;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.SaveRequest;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;

@RequiredArgsConstructor
class RequestMapper {
  private final AllMember allMember;
  private final PersistingPlaylist persistingPlaylist;

  Result<SaveRequest> toSaveRequest(JsonSaveRequest jsonSaveRequest) {
    Member member = allMember.findByLoginId(jsonSaveRequest.loginId());

    if (member == null) {
      return new Result<>(Either.left(failForBadRequest("유효하지 않은 loginId입니다.")));
    }

    return new Result<>(Either.right(
      SaveRequest.builder()
        .loginId(jsonSaveRequest.loginId())
        .title(jsonSaveRequest.title())
        .isMember(member.isMember())
        .playlistCount(persistingPlaylist.havingCountOf(member.id()))
        .build()));
  }
}