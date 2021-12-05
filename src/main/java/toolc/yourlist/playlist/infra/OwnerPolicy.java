package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.EqualOwnerCondition;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.ReadPlaylist;

@RequiredArgsConstructor
final class OwnerPolicy implements EqualOwnerCondition {
  private final AllMember allMember;
  private final ReadPlaylist readPlaylist;

  @Override
  public boolean check(Member member, Playlist playlist) {
    return member.id().equals(playlist.memberId());
  }
}
