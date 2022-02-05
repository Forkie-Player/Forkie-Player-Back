package toolc.yourlist.playlist.domain;

import java.util.function.Function;
import java.util.stream.Stream;

public interface StreamForFirstCollection<T> {
  <R> Stream<R> map(Function<? super T, ? extends R> mapper);
}
