package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.JpaAllMember;
import toolc.yourlist.play.domain.PlaylistRepository;

@RequiredArgsConstructor
class PlaylistRequestMapper {
  private final JpaAllMember jpaAllMember;
  private final PlaylistRepository playlistRepository;

}
