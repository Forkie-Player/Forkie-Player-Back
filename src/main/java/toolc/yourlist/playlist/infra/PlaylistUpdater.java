package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.EqualOwnerCondition;
import toolc.yourlist.playlist.domain.UpdatePlaylist;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
class PlaylistUpdater implements UpdatePlaylist {
  private final AllPlaylists allPlaylists;
  private final AllMember allMember;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  @Override
  public void updateTitle(UpdateRequest request) {
    var member = allMember.findById(request.memberId());
    var playlist = allPlaylists.readBelongsTo(request.playlistId());

    if (!equalCondition.check(member, playlist)) {
      throw new IllegalArgumentException("Playlist 소유자의 요청이 아닙니다.");
    }

    allPlaylists.updateTitleBelongsTo(request.playlistId(), request.title());
  }
}
