package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
final class PlaylistCreator {
  private final AllMember allMember;
  private final SavePersisting savePersisting;
  private final CountPolicyForNonMember countPolicy;

  void createForRealMember(Long memberId, String title) {
    var member = allMember.findById(memberId);

    if (!member.isMember()) {
      throw new IllegalArgumentException("회원이 아닙니다.");
    }

    save(playlist(memberId, title));
  }

  void createForNonMember(Long memberId, String title) {
    var member = allMember.findById(memberId);

    if (member.isMember()) {
      throw new IllegalArgumentException("비회원이 아닙니다.");
    }

    if (!countPolicy.check(memberId)) {
      throw new IllegalArgumentException("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(memberId, title));
  }

  private void save(Playlist playlist) {
    savePersisting.save(playlist);
  }

  private Playlist playlist(Long memberId, String title) {
    return Playlist.builder()
      .memberId(memberId)
      .title(title)
      .build();
  }
}
