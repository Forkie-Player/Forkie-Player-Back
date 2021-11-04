package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginId2Test {

  @Test
  void Should_Be_Same_When_Raw_Is_Same() {
    assertThat(new LoginId2("jisoo98"), is(new LoginId2("jisoo98")));
  }

  @Test
  void Raw_Should_Be_Non_Null(){
    assertThrows(IllegalArgumentException.class, () -> new LoginId2(null));
  }

  @Test
  void Raw_Should_Be_Non_Empty(){
    assertThrows(IllegalArgumentException.class, () -> new LoginId2(""));
  }

  @Test
  void Should_Not_Throws_Exception_When_Raw_Is_Validated() {
    assertDoesNotThrow(() -> new LoginId2("jisoo98"));
  }

  @Test
  void Raw_Should_Validated() {
    String raw = "jisoo98";
    assertThat(new LoginId2(raw).raw, allOf(startsWith(raw.toLowerCase().substring(0, 1))));
    /*
    1. raw 값을 사용해 비교해 보려고 하였는데 raw 가 private 이라면 직접 비교할 수 가 없다
      테스트를 위해 raw에 접근 제한자를 바꾸는건 올바르지 않은 방법 인 것 같음
    2. raw 값을 가져온지 않는다면 validate 함수를 검사해야하는데 이것도 마찬가지로 private....
    3. raw 값을 가져온다고 해서 allOf을 사용할 수 없었음, length() 사용 불가, 자체로만 비교 가능
    4. 처음에 쓰기 싫었던 should validated를 결국 쓰게됨...
     */
  }

  @Test
  void Raw_Should_Validated2() {
    String raw = "jisoo98";

    assertAll(
      () -> assertThrows(IllegalArgumentException.class, () -> new LoginId2(raw.toUpperCase())),
      () -> assertThrows(IllegalArgumentException.class, () -> new LoginId2(raw.substring(0, 5))),
      () -> assertThrows(IllegalArgumentException.class, () ->
        new LoginId2(raw.replaceAll("[0-9]", "")))
    );
    /*
    1. 무수히 많은 검증이 필요함...너무 많은 assert 문이 생긴다.
    ex) 한글이 포함되지 않아야한다, 뛰어쓰기가 있으면 안된다, 숫자만 있으면 안된다.
    -> 통과하는 테스트를 만드는게 좋다
    (https://stackoverflow.com/questions/155436/unit-test-naming-best-practices)
    2. 테스트는 구현체가 되면 안된다? - 구현이 아니라 테스트 코드여야한다 -> 너무 raw 한 값을 사용하나?
    3.
     */

  }
}