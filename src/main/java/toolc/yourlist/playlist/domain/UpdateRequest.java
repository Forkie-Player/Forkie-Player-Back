package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public final class UpdateRequest {
  private final Long memberId;
  private final Long playlistId;
  private final String title;
}
