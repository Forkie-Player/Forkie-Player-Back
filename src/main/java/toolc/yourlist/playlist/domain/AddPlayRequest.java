package toolc.yourlist.playlist.domain;

public record AddPlayRequest(
  EqualMemberForPlaylist equalMemberForPlaylist,
  PlayInfo info,
  PlayTime time,
  Channel channel) {
}
