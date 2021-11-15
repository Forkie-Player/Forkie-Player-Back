package toolc.yourlist.auth.domain;


public interface PasswordPolicy {
  boolean matches(String rawPassword);
}

