package toolc.yourlist.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ReissueRequest {
  private String accessToken;
  private String refreshToken;
  private boolean isPC;
}
