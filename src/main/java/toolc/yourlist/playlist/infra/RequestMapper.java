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
    }

    return SaveRequest.builder()
      .memberId(member.id())
      .title(jsonSaveRequest.title())
      .isMember(member.isMember())
      .playlistCount(persistingPlaylist
        .readAllBelongsTo(member.id())
        .entities()
        .size())
      .build();
  }
}