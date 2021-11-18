package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlaylistRepository;

import java.util.List;

@RequiredArgsConstructor
public class PlaylistStorage {
  private final PlaylistRepository playlistRepository;

  List<Playlist> readWhatBelongsTo(Long memberId) {
    return playlistRepository.findByMemberId(memberId);
  }

//  void save(JsonPlaylistSaveRequest request) { // 회원이면 제한X, but 비회원이면 최대 5개... -> 앞에서 비회원이고 현재 playlist갯수가 5개면 badrequest로 응답하면 될 듯.?
//    playlistRepository.save(Playlist.builder()
//      .memberId(request.loginId())
//      .title(request.title())
//      .build());
//  }
}
