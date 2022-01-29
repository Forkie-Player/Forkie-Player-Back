package toolc.yourlist.playlist.domain;

public record UpdateRequest(
  EqualOwnerForPlaylist equalOwnerForPlaylist,
  String title) {
}
