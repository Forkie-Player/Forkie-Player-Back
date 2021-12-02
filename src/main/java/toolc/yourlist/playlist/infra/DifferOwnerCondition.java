package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class DifferOwnerCondition {
  private final AllMember allMember;
  private final ReadPersisting readPersisting;

  boolean check(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = readPersisting.readBelongsTo(playlistId);

    return !member.id().equals(playlist.memberId());
  }
}
