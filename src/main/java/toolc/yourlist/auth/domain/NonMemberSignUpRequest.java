package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public final class NonMemberSignUpRequest {
  private final String deviceId;
}
