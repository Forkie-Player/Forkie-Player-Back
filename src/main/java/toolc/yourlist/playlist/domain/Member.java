package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Member(Long id, String loginId, boolean isMember, String password) {
  @Builder
  public Member {
  }
}
