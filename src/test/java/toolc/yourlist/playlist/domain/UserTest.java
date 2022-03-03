package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.member.domain.UserType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  @Test
  void code() {
    var authUser = new AuthenticationUser(1L, UserType.MEMBER);
    var user = new User(authUser);

    var actual = user.code();
    assertThat(actual, is("MEMBER_1"));
  }
}