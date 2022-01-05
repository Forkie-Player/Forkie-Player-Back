package toolc.yourlist.playlist.domain;

public record UpdateRequest(
  Member member,
  Playlist playlist,
  String title) {
}
