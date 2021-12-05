package toolc.yourlist.playlist.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Playlist {
  private final Long memberId;
  private final String title;
  private final String thumbnail;

  @Builder
  public Playlist(Long memberId, String title, String thumbnail) {
    this.memberId = memberId;
    this.title = title;
    this.thumbnail = thumbnail;
  }
}
