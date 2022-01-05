package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Playlist(Long id, Long memberId, String title, String thumbnail) {
  @Builder
  public Playlist {
  }
}
