package org.da0hn.lambdas;

/**
 * @author daohn
 * @since 19/06/2021
 */
public interface IConfigurator<T, R> {

  R configure(T t);

}
