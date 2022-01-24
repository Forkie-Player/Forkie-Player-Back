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
  Channel channel) implements Comparable<Play> {
  @Builder
  public Play {
  }

  @Override
  public int compareTo(Play play) {
    return sequence.compareTo(play.sequence);
  }
}
