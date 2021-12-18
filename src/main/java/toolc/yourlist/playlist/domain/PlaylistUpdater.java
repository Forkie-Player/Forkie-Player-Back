package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

import java.util.Optional;

@RequiredArgsConstructor
public class PlaylistUpdater {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  public Optional<String> updateTitle(UpdateRequest request) {
    var member = allMember.findById(request.memberId());
    var playlist = allPlaylists.readBelongsTo(request.playlistId());

    if (member.isEmpty()) {
      return Optional.of("존재하지 않는 회원");
    }
    if (playlist.isEmpty()) {
      return Optional.of("존재하지 않는 영상 목록");
    }
    if (!equalCondition.check(member.get(), playlist.get())) {
      return Optional.of("Playlist 소유자의 요청이 아닙니다.");
    }

    allPlaylists.updateTitleBelongsTo(request.playlistId(), request.title());

    return Optional.empty();
  }
}
