package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Play (
  Long id,
  String title,
  String videoId,
  String thumbnail,
  Long playlistId,
  Long sequence,
  PlayTime playTime,
  Channel channel){
  @Builder
  public Play {
  }
}