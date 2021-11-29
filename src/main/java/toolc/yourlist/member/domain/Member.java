package toolc.yourlist.member.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Member {
  private final Long id;
  private final String loginId;
  private final boolean isMember;
  private final String password;
}
