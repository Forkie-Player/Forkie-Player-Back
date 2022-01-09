package toolc.yourlist.playlist.play.infra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonAddRequest(
  @NotNull Long memberId,
  @NotNull Long playlistId,
  @NotBlank String thumbnail,
  @NotNull Long startTime,
  @NotNull Long endTime,
  @NotBlank String videoId,
  @NotBlank String title,
  @NotBlank String channelTitle,
  @NotBlank String channelImg
) {
}
