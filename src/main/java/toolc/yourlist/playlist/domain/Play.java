package toolc.yourlist.playlist.domain;

import lombok.Builder;

public record Play (
  Long id,
  Long playlistId,
  Long sequence,
  PlayInfo info,
  PlayTime time,
  Channel channel){
  @Builder
  public Play {
  }
}