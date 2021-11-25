package toolc.yourlist.common.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class Result<T> {
  private final Either<ResponseEntity, T> either;

  public boolean isFail() {
    return either.isLeft();
  }

  public T success() {
    return either.get();
  }

  public ResponseEntity fail() {
    return either.getLeft();
  }
}
