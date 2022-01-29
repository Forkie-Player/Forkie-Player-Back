package toolc.yourlist.playlist.domain;

public record AddPlayRequest(
  EqualOwnerForPlaylist equalOwnerForPlaylist,
  PlayInfo info,
  PlayTime time,
  Channel channel) {
}
