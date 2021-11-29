package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
public class EqualOwnerCondition {
  private final AllMember allMember;

  boolean check(Member member, Playlist playlist) {
    return member.equals(allMember.findById(playlist.memberId()));
  }
}
