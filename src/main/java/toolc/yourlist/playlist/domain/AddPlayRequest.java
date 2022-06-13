package toolc.yourlist.playlist.domain;

public record AddPlayRequest(
  ValidRequestForPlaylist validRequestForPlaylist,
  PlayInfo info,
  PlayTime time,
  Channel channel,
  Platform platform) {
}
