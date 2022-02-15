package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import toolc.yourlist.playlist.domain.exception.DuplicateIdInListException;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
abstract class FirstClassCollection<T> {
  private final List<T> list;

  abstract Long id(T element);

  public FirstClassCollection(List<T> list) {
    final int idCount = list.stream()
      .map(this::id)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (idCount != list.size()) {
      throw new DuplicateIdInListException();
    }

    this.list = list;
  }

  void forEach(Consumer<? super T> action) {
    list.forEach(action);
  }

  public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
    return list.stream().map(mapper);
  }
}
