package org.da0hn.usecases.push_vs_pull;

/**
 * @author daohn
 * @since 13/07/2021
 */
interface ICallback {

  void pushData(String data);

  void pushComplete();

  void pushError(Exception exception);
}
