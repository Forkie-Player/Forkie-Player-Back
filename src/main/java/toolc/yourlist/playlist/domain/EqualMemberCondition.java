package toolc.yourlist.playlist.domain;

final class EqualMemberCondition {
  void check(Member member, Playlist playlist) {
    if (!member.id().equals(playlist.memberId())) {
      throw new NotOwnerException();
    }
  }
}
