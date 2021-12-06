package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.EqualOwnerCondition;
import toolc.yourlist.playlist.domain.UpdatePlaylist;
import toolc.yourlist.playlist.domain.UpdateRequest;

import java.util.Optional;

@RequiredArgsConstructor
class PlaylistUpdater implements UpdatePlaylist {
  private final AllPlaylists allPlaylists;
  private final AllMember allMember;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  @Override
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
