package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public class ReadRequest {
  private final Member member;

  ReadRequest(Member member) {
    this.member = member;
  }
}
