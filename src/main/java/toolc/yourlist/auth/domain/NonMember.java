package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
final class NonMember {
  private String uuid;

  public NonMember(String uuid) {
    if(uuid == null || uuid.equals("")) throw new IllegalArgumentException("잘못된 UUID 입니다.");
    this.uuid = uuid;
  }
}
