package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRequestFactory {
  private final AllMember allMember;

  public SaveRequest create(Long memberId, String title) {
    var member = allMember.findById(memberId);

    return new SaveRequest(member, title);
  }
}
