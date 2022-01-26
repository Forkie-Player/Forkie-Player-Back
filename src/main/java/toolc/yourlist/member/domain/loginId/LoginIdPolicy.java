package toolc.yourlist.member.domain.loginId;

public interface LoginIdPolicy {
  boolean matches(String rawId);
}

