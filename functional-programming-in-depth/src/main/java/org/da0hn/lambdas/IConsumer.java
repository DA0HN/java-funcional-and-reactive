package org.da0hn.lambdas;

import java.util.Objects;

/**
 * @author daohn
 * @since 19/06/2021
 */
@FunctionalInterface
public interface IConsumer<T> {

  void accept(T t);

  default IConsumer<T> thenAccept(IConsumer<T> next) {

    Objects.requireNonNull(next);

    return (T t) -> {
      this.accept(t);
      next.accept(t);
    };
  }
}
