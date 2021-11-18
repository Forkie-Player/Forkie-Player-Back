package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.JpaAllMember;

@RequiredArgsConstructor
class PlaylistRequestMapper {
  private final JpaAllMember jpaAllMember;
  private final Playlist playlist;

}
