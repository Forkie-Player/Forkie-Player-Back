package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

@RequiredArgsConstructor
public class JpaSaveAdapter implements SavePersisting {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;
  private final SavePolicy savePolicy;

  @Override
  public void saveByRequest(SaveRequest request) {
    if (!savePolicy.matches(request)) {
      throw new IllegalArgumentException("[비회원] 생성 갯수 초과");
    }

    Member member = allMember.findByLoginId(request.loginId());

    if (member == null) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    playlistRepository.save(new PlaylistEntity(
      member.id(),
      request.title()));
  }
}
