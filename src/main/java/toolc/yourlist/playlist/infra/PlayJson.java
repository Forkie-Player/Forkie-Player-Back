package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Play;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record PlayJson(
  @NotNull Long id,
  @NotBlank String title,
  @NotBlank String videoId,
  @NotNull Long sequence,
  @NotBlank String thumbnail,
  @NotNull Long start,
  @NotNull Long end,
  @NotBlank String channelImage,
  @NotBlank String channelTitle
) {
  public PlayJson(Play play) {
    this(play.id(),
      play.title(),
      play.videoId(),
      play.sequence(),
      play.thumbnail(),
      play.playTime().startTime(),
      play.playTime().endTime(),
      play.channel().image(),
      play.channel().title());
  }
}
