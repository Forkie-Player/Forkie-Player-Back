package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Play(String title,
                   String videoId,
                   String thumbnail,
                   Long playlistId,
                   PlayTime playTime,
                   Channel channel) {
  @Builder
  public Play {
  }
}
