package toolc.yourlist.playlist.domain;

final class EqualOwnerCondition {
  void check(Member member, Playlist playlist) {
    if (!member.id().equals(playlist.memberId())) {
      throw new NotOwnerException();
    }
  }
}
