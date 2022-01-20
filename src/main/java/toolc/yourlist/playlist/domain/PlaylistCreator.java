package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final SavePolicy savePolicy = new SavePolicy();

  public Either<String, Boolean> create(SaveRequest request) {
    var member = allMember.findById(request.memberId());
    var playlistCount = allPlaylists.havingCountOf(member.id());

    if (!savePolicy.match(member, playlistCount)) {
      return Either.left("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(member.id(), request.title()));
    return Either.right(Boolean.TRUE);
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
