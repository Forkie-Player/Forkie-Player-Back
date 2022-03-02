package toolc.yourlist.member.infra;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import toolc.yourlist.member.domain.UserType;

import java.util.Collections;

@Getter
public class CustomUser extends User {

  private Long id;
  private UserType userType;

  public CustomUser(Long id, String userType) {
    super("don't_use", "don't_use", Collections.emptyList());
    this.userType = UserType.valueOf(userType);
    this.id = id;
  }
}
