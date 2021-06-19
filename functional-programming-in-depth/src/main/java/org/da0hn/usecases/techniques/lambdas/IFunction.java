package org.da0hn.usecases.techniques.lambdas;

import java.util.function.Function;

/**
 * @author daohn
 * @since 19/06/2021
 */
public interface IFunction<T, R> {

  R apply(T t);

  default <U> Function<U, R> compose(IFunction<U, T> before) {
    return (U u) -> apply(before.apply(u));
  }
}
