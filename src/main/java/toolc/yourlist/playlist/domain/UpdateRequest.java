package toolc.yourlist.playlist.domain;

public record UpdateRequest(
  EqualMemberForPlaylist equalMemberForPlaylist,
  String title) {
}
