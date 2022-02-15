package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;

class StringConverter {
  public Either<String, Long> toLong(String stringValue) {
    try {
      Long longValue = Long.parseLong(stringValue);

      return Either.right(longValue);
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
