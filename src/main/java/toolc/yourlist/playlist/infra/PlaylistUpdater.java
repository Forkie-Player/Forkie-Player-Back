package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.common.domain.ContractViolationException;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.EqualOwnerCondition;
import toolc.yourlist.playlist.domain.UpdatePlaylist;
import toolc.yourlist.playlist.domain.UpdateRequest;

import java.util.Optional;

import static toolc.yourlist.common.domain.Contracts.requires;

@RequiredArgsConstructor
class PlaylistUpdater implements UpdatePlaylist {
  private final AllPlaylists allPlaylists;
  private final AllMember allMember;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  @Override
  public Optional<String> updateTitle(UpdateRequest request) {
    try {
      var member = allMember.findById(request.memberId());
      var playlist = allPlaylists.readBelongsTo(request.playlistId());

      requires(equalCondition.check(member, playlist), "Playlist 소유자의 요청이 아닙니다.");

      allPlaylists.updateTitleBelongsTo(request.playlistId(), request.title());

      return Optional.empty();
    } catch (ContractViolationException e) {
      return Optional.of(e.getMessage());
    }
  }
}
