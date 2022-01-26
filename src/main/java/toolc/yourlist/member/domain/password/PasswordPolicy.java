package toolc.yourlist.member.domain.password;

public interface PasswordPolicy {
  boolean matches(String rawPassword);
}

