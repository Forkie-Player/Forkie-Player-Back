package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@EqualsAndHashCode
class StreamMixIn<T> implements StreamForFirstCollection<T> {
  private final List<T> list;

  public StreamMixIn(List<T> list) {
    this.list = list;
  }

  @Override
  public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
    return list.stream().map(mapper);
  }
}
