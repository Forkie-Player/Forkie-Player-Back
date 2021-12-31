package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ReadRequest {
  private final Member member;

  ReadRequest(Member member) {
    this.member = member;
  }
}
