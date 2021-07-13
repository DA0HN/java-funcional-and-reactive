package org.da0hn;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author daohn
 * @since 13/07/2021
 */
public class RxJavaUseCase {

  public static void main(String[] args) {
    Observable<String> source = Observable.create(
      e -> {
        e.onNext("Hello");
        e.onNext("RxJava");
      }
    );

    var disposable = source.subscribe(e -> System.out.println("Observer 1: " + e));
    var disposable2 = source.subscribe(e -> System.out.println("Observer 2: " + e));
    disposable.dispose();
    disposable2.dispose();

  }

}
