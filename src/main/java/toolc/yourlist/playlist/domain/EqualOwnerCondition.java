package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.Member;

@RequiredArgsConstructor
public final class EqualOwnerCondition {

  public boolean check(Member member, Playlist playlist) {
    return member.id().equals(playlist.memberId());
  }
}
