package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.EqualOwnerCondition;

@RequiredArgsConstructor
final class OwnerPolicy {
  private final AllMember allMember;
  private final ReadPersisting readPersisting;
  private final EqualOwnerCondition equalOwnerCondition = new EqualOwnerCondition();

  boolean check(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = readPersisting.readBelongsTo(playlistId);

    return equalOwnerCondition.check(member, playlist);
  }
}
