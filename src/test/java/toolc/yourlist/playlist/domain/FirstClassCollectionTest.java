package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.exception.DuplicateIdInListException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FirstClassCollectionTest {
  class TestElement {
    Long id;

    public TestElement(Long id) {
      this.id = id;
    }
  }

  @Test
  void duplicate_id() {
    var list = List.of(
      new TestElement(1L),
      new TestElement(2L),
      new TestElement(2L)
    );
    assertThrows(DuplicateIdInListException.class, () -> new FirstClassCollection<>(list) {
      @Override
      Long id(TestElement element) {
        return element.id;
      }
    });
  }
}