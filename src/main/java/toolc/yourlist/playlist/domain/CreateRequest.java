package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public class CreateRequest {
  private final Member member;
  private final String title;

  CreateRequest(Member member, String title) {
    this.title = title;
    this.member = member;
  }
}
