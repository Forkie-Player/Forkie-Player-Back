package toolc.yourlist.play.infra;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public final class JsonPlaylistSaveRequest {
  @NotNull
  private final String loginId;
  @NotEmpty
  private final String title;

  @Builder
  JsonPlaylistSaveRequest(String loginId, String title) {
    this.loginId = loginId;
    this.title = title;
  }
}
