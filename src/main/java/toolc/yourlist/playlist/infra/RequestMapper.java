package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.SaveRequest;

@RequiredArgsConstructor
class RequestMapper {
  private final AllMember allMember;
  private final PersistingPlaylist persistingPlaylist;

  SaveRequest toSaveRequest(JsonSaveRequest jsonSaveRequest) {
    Member member = allMember.findByLoginId(jsonSaveRequest.loginId());

    if (member == null) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    } // TODO: 예외가 아니라 BadRequest

    return SaveRequest.builder()
      .loginId(jsonSaveRequest.loginId())
      .title(jsonSaveRequest.title())
      .isMember(member.isMember())
      .playlistCount(persistingPlaylist
        .readAllBelongsTo(jsonSaveRequest.loginId())
        .entities()
        .size())
      .build();
  }
}