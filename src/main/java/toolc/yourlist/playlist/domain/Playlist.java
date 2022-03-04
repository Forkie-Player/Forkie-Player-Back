package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Playlist(Long id,
                       String userCode,
                       String title,
                       String thumbnail) {
  @Builder
  public Playlist {
  }
}
