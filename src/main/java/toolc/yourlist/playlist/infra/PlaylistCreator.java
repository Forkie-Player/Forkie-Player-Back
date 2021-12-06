package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.CreatePlaylist;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
class PlaylistCreator implements CreatePlaylist {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final SavePolicy savePolicy = new SavePolicy();

  @Override
  public void createPlaylist(Long memberId, String title) {
    var member = allMember.findById(memberId);
    var playlistCount = allPlaylists.havingCountOf(memberId);

    if (!savePolicy.match(member, playlistCount)) {
      throw new IllegalArgumentException("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(memberId, title));
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
