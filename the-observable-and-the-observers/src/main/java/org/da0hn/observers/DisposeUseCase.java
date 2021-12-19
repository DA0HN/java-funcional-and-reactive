package org.da0hn.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

final class DisposeUseCase {

  public static void main(final String[] args) throws InterruptedException {
    final var source = Observable.interval(1, TimeUnit.SECONDS);
    disposeExample(source);
    disposeExample2(source);
  }

  private static void disposeExample2(final Observable<Long> source) throws InterruptedException {

    System.out.println("-".repeat(50));
    System.out.println("Example 2");
    System.out.println("-".repeat(50));

    final var disposable1 = source.subscribe(e -> System.out.println("Observer 1: " + e));
    final var disposable2 = source.subscribe(e -> System.out.println("Observer 2: " + e));

    Thread.sleep(5000);

    final var compositeDisposable = new CompositeDisposable();

    compositeDisposable.addAll(disposable1, disposable2);

    Thread.sleep(5000);

    compositeDisposable.dispose();
  }

  private static void disposeExample(final Observable<Long> source) throws InterruptedException {
    System.out.println("-".repeat(50));
    System.out.println("Example 1");
    System.out.println("-".repeat(50));

    final var disposable1 = source.subscribe(e -> System.out.println("Observer 1: " + e));

    Thread.sleep(2000);

    source.subscribe(disposableObserver());

    Thread.sleep(10000);

    disposable1.dispose();

    source.subscribe(e -> System.out.println("Observer 3: " + e));

    Thread.sleep(5000);
  }

  private static Observer<Long> disposableObserver() {
    return new Observer<>() {

      private Disposable d;

      @Override public void onSubscribe(@NonNull final Disposable d) {
        this.d = d;
      }

      @Override public void onNext(@NonNull final Long aLong) {
        System.out.println("Disposable Observer 1: " + aLong);
        this.d.dispose();
      }

      @Override public void onError(@NonNull final Throwable e) {

      }

      @Override public void onComplete() {
        System.out.println("Disposable Observer 1: Completed!");
      }
    };
  }


}
