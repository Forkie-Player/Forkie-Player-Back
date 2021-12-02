package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final SavePersisting savePersisting;
  private final MemberCondition memberCondition;
  private final PlaylistCountCondition playlistCountCondition;

  void createForRealMember(Long memberId, String title) {
    if (memberCondition.checkNonMember(memberId)) {
      throw new IllegalArgumentException("회원이 아닙니다.");
    }

    savePersisting.save(Playlist.builder()
      .memberId(memberId)
      .title(title)
      .build());
  }

  void createForNonMember(Long memberId, String title) {
    if (memberCondition.checkRealMember(memberId)) {
      throw new IllegalArgumentException("비회원이 아닙니다.");
    }

    if (playlistCountCondition.check(memberId)) {
      throw new IllegalArgumentException("비회원의 영상 생성 제한을 넘었습니다.");
    }

    savePersisting.save(Playlist.builder()
      .memberId(memberId)
      .title(title)
      .build());
  }
}
