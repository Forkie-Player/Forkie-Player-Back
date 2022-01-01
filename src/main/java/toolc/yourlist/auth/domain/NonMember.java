package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public final class NonMember {

  private final Long id;
  private final String deviceId;

  public NonMember(Long id, String deviceId) {
    if (deviceId == null || deviceId.equals(""))
      throw new IllegalArgumentException("잘못된 UUID 입니다.");
    this.id = id;
    this.deviceId = deviceId;
  }
}
