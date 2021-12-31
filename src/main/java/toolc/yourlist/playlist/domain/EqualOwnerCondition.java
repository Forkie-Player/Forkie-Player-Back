package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class EqualOwnerCondition {
  boolean check(Member member, Playlist playlist) {
    return member.id().equals(playlist.memberId());
  }
}
