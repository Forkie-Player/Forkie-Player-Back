package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

import java.util.Optional;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final SavePolicy savePolicy = new SavePolicy();

  public Optional<String> createPlaylist(Long memberId, String title) {
    var member = allMember.findById(memberId);
    var playlistCount = allPlaylists.havingCountOf(memberId);

    if (member.isEmpty()) {
      return Optional.of("존재하지 않는 회원");
    }
    if (!savePolicy.match(member.get(), playlistCount)) {
      return Optional.of("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(memberId, title));
    return Optional.empty();
  }

  private void save(Playlist playlist) {
    allPlaylists.save(playlist);
  }

  private Playlist playlist(Long memberId, String title) {
    return Playlist.builder()
      .memberId(memberId)
      .title(title)
      .build();
  }
}
