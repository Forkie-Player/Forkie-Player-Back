package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SaveRequest {
  private final Member member;
  private final String title;

  SaveRequest(Member member, String title) {
    this.title = title;
    this.member = member;
  }
}
