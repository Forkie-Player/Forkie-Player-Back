package toolc.yourlist.playlist.domain;

public record UpdateRequest(
  EqualOwner equalOwner,
  String title) {
}
