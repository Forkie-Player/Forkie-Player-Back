package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
final class NonMemberLoginRequest {
  private final String deviceId;

  public NonMemberLoginRequest(String deviceId) {
    checkNullOrEmpty(deviceId);
    this.deviceId = deviceId;
  }

  private void checkNullOrEmpty(String deviceId) {
    if(deviceId == null || deviceId.equals(""))
      throw new IllegalArgumentException("잘못된 UUID 입니다.");
  }
}
