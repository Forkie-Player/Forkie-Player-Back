package toolc.yourlist.playlist.infra;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonAddPlayRequest(
  @NotNull Long playlistId,
  @NotBlank String thumbnail,
  @NotNull Long startTime,
  @NotNull Long endTime,
  @NotBlank String videoId,
  @NotBlank String title,
  @NotBlank String channelTitle,
  @NotBlank String channelImg
) {
  @Builder
  public JsonAddPlayRequest {}
}
