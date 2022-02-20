package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TokenProviderTest {

  TokenReader tokenReader = Mockito.mock(TokenReader.class);

  TimeServer timeServer = new FakeTimeServer(Instant.parse("2022-02-06T10:15:30.00Z"));

  TokenSerializer mockTokenSerializer = Mockito.mock(TokenSerializer.class);

  TokenProvider tokenProvider = new TokenProvider(tokenReader, timeServer, mockTokenSerializer);

  @Test
  void token_valid_at_same_time_using_app() {

    Long id = anyId();
    UserType userType = anyUserType();

    tokenProvider.makeToken(id, false, userType);

    verify(mockTokenSerializer, times(1))
      .makeToken(id, Instant.parse("2022-02-06T10:45:30.00Z"), Instant.parse("2022-02-13T10:15:30.00Z"), userType);
  }

  @Test
  void token_valid_at_same_time_using_pc() {
    Long id = anyId();
    UserType userType = anyUserType();

    tokenProvider.makeToken(id, true, userType);

    verify(mockTokenSerializer, times(1))
      .makeToken(id, Instant.parse("2022-02-06T10:45:30.00Z"), Instant.parse("2022-03-08T10:15:30" +
        ".00Z"), userType);
  }

  private Long anyId() {
    return ThreadLocalRandom.current().nextLong();
  }

  private UserType anyUserType() {
    return ThreadLocalRandom.current().nextBoolean() ? UserType.VISITOR : UserType.MEMBER;
  }
}