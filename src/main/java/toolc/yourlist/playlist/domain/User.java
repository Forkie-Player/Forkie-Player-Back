package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.member.domain.UserType;

public record User(UserType userType, Long id) {
  public User(AuthenticationUser authenticationUser) {
    this(authenticationUser.userType(), authenticationUser.id());
  }

  public String code() {
    return userType.name() + '_' + id;
  }
}
