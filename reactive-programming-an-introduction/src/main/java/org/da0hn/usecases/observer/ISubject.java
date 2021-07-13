package org.da0hn.usecases.observer;

/**
 * @author daohn
 * @since 13/07/2021
 */
interface ISubject {

  void subscribe(IObserver observer);
  void unsubscribe(IObserver observer);
  void notifyObserver();

}
