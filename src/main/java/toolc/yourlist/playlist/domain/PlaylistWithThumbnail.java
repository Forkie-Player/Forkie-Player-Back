package toolc.yourlist.playlist.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class PlaylistWithThumbnail {
  private final Long id;
  private final String title;
  private final String thumbnail;
}
