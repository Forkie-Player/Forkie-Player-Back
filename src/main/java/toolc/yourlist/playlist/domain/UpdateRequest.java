package toolc.yourlist.playlist.domain;

public record UpdateRequest(
  ValidRequestForPlaylist validRequestForPlaylist,
  String title) {
}
