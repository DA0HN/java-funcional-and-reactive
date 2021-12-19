package org.da0hn.observers;

import io.reactivex.rxjava3.core.Observable;

final class CreatingObserverUseCase {

  public static void main(final String[] args) {
    final Observable<String> source = Observable.just("Orange", "Black", "Red");

    source.subscribe(
      src -> System.out.println(src),
      Throwable::printStackTrace,
      () -> System.out.println("Completed!")
    );

    System.out.println();

    source.subscribe(System.out::println, Throwable::printStackTrace);

    System.out.println();

    source.subscribe(System.out::println);

  }

}
