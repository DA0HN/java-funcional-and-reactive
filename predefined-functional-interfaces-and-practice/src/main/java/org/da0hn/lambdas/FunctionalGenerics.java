package org.da0hn.lambdas;

/**
 * Created by daohn on 14/06/2021
 * @author daohn
 * @since 14/06/2021
 */
@FunctionalInterface
public interface FunctionalGenerics<T, R> {

  R execute(T str);

}
