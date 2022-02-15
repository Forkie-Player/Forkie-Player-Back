package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class StringConverterTest {
  @Test
  void toLong() {
    var converter = new StringConverter();

    var actual = converter.toLong("123");

    var expected = 123L;
    assertThat(actual, is(right(expected)));
  }

  @Test
  void toLong_not_number_format() {
    var converter = new StringConverter();

    var actual = converter.toLong("abs123");

    var expected = "입력이 숫자 형식이 아닙니다.";
    assertThat(actual, is(left(expected)));
  }
}