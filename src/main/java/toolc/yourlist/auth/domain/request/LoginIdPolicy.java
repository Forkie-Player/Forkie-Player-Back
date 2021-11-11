package toolc.yourlist.auth.domain.request;

interface LoginIdPolicy {
  boolean matches(String rawId);
}

