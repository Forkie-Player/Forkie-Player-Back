package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
final class NonMember {
  private String uuid;

  public NonMember(String uuid) {
    this.uuid = uuid;
  }
}
