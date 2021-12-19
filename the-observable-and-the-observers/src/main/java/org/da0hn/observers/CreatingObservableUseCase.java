package org.da0hn.observers;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

final class CreatingObservableUseCase {

  public static void main(final String[] args) {
    usingCreate();
    usingJust();
    usingFromIterable();
    usingRange();
  }

  private static void usingRange() {
    Observable.range(3, 10)
      .subscribe(System.out::println);
  }

  private static void usingFromIterable() {
    final var itens = List.of("Ram", "Shyam", "Mike");

    final Observable<String> fromIterable = Observable.fromIterable(itens);

    fromIterable.subscribe(System.out::println);

  }

  private static void usingJust() {
    final Observable<Integer> just = Observable.just(1, 2, 3);

    just.subscribe(System.out::println);
  }

  private static void usingCreate() {
    final Observable<Integer> source = Observable.create(emitter -> {
      emitter.onNext(10);
      emitter.onNext(11);
      emitter.onNext(12);
      emitter.onComplete();
    });

    source.subscribe(System.out::println);
  }

}
