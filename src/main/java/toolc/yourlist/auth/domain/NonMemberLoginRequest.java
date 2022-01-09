package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public final class NonMemberLoginRequest {
  private final String deviceId;
  private final AuthExpiration authExpiration;
  private final String TokenSaveNamePrefix;

  public NonMemberLoginRequest(String deviceId, AuthExpiration authExpiration
    , String TokenSaveNamePrefix) {
    this.authExpiration = authExpiration;
    checkNullOrEmpty(deviceId);
    this.deviceId = deviceId;
    this.TokenSaveNamePrefix = TokenSaveNamePrefix;
  }

  private void checkNullOrEmpty(String deviceId) {
    if (deviceId == null || deviceId.equals(""))
      throw new IllegalArgumentException("잘못된 UUID 입니다.");
  }
}
