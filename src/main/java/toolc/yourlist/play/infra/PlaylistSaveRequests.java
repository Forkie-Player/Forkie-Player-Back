package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.MemberRepository;
import toolc.yourlist.play.domain.PlaylistRepository;

import java.util.Optional;

import static toolc.yourlist.common.domain.Contracts.requires;

@RequiredArgsConstructor
public class PlaylistSaveRequests {
  private final MemberRepository memberRepository;
  private final PlaylistRepository playlistRepository;

  PlaylistSaveRequest of(Long memberId, String title) {
    Optional<Member> optionalMember = memberRepository.findById(memberId);
    requires(optionalMember.isPresent(), "멤버 존재X");

    return PlaylistSaveRequest.builder()
      .memberId(memberId)
      .title(title)
      .isMember(optionalMember.get().isMember())
      .playlistCount(playlistRepository.findByMemberId(memberId).size())
      .build();
  }
}
