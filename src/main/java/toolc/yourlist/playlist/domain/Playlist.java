package toolc.yourlist.playlist.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Playlist {
  private final Long id;
  private final Long memberId;
  private final String title;
  private final String thumbnail;

  @Builder
  public Playlist(Long id, Long memberId, String title, String thumbnail) {
    this.id = id;
    this.memberId = memberId;
    this.title = title;
    this.thumbnail = thumbnail;
  }
}
