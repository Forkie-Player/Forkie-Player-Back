package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
final class NonMemberLoginRequest {
  private final String deviceId;
  private final Device device;

  public NonMemberLoginRequest(String deviceId, Device device) {
    this.device = device;
    checkNullOrEmpty(deviceId);
    this.deviceId = deviceId;
  }

  private void checkNullOrEmpty(String deviceId) {
    if (deviceId == null || deviceId.equals(""))
      throw new IllegalArgumentException("잘못된 UUID 입니다.");
  }
}
