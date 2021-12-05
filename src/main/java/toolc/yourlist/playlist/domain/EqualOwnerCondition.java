package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.Member;

@RequiredArgsConstructor
public interface EqualOwnerCondition {

  boolean check(Member member, Playlist playlist);
}
