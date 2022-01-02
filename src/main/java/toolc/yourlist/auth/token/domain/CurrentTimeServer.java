package toolc.yourlist.auth.token.domain;


import java.time.Instant;

public interface CurrentTimeServer {
  Instant now();
}

