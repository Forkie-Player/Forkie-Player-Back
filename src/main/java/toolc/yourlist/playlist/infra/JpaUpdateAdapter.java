package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class JpaUpdateAdapter implements UpdatePersisting {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;

  @Override
  public void updateTitle(UpdateRequest request) {
    PlaylistEntity entity = playlistRepository
      .findById(request.playlistId())
      .orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 영상 목록입니다."));

    if (!request.member().equals(allMember.findById(entity.memberId()))) {
      throw new IllegalArgumentException("영상목록의 주인이 아닙니다.");
    }

    entity.title(request.title());
  }
}
