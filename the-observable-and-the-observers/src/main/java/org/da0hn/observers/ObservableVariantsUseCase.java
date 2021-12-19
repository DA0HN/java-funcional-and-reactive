package org.da0hn.observers;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

final class ObservableVariantsUseCase {

  public static void main(final String[] args) {
    final var source = Observable.just("Alex", "Justin", "Jack");
    singleObservable(source);
    maybeObservable(source);

    final Completable completable = Completable.complete();
    completable.subscribe(() -> System.out.println("Completed"));

    Completable.fromRunnable(() -> System.out.println("Some process executing"))
      .subscribe(() -> System.out.println("The process executed successfully"));

  }

  private static void maybeObservable(final Observable<String> source) {
    source.firstElement()
      .subscribe(System.out::println);

    Observable.empty().firstElement().subscribe(
      System.out::println,
      Throwable::printStackTrace,
      () -> System.out.println("Completed")
    );
  }

  private static void singleObservable(final Observable<String> source) {
    source.first("Name")
      .subscribe(System.out::println);

    final var singleSource = Single.just("Abacate");
    singleSource.subscribe(System.out::println);
  }

}
