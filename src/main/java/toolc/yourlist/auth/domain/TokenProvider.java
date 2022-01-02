package toolc.yourlist.auth.domain;

public interface TokenProvider {
  Token create(Long id, boolean isPC);
}

