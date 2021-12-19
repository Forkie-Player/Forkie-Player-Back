package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public class SaveRequest {
  private final Member member;
  private final String title;

  public SaveRequest(Member member, String title) {
    this.title = title;
    this.member = member;
  }
}
