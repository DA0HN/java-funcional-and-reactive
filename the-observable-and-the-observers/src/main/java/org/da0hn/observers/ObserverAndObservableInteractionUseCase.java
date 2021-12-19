package org.da0hn.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

final class ObserverAndObservableInteractionUseCase {

  public static void main(final String[] args) {
    final Observable<Integer> source = new ObservableCreate<>(new ObservableOnSubscribe<Integer>() {
      @Override public void subscribe(@NonNull final ObservableEmitter<Integer> emitter) throws Throwable {
        try {
          emitter.onNext(10);
          emitter.onNext(11);
          emitter.onComplete();
        }
        catch(final Exception e) {
          emitter.onError(e);
        }
      }
    });

    final Observer<Integer> observer = new Observer<>() {

      @Override public void onSubscribe(@NonNull final Disposable d) {
        System.out.println("Subscribed");
      }

      @Override public void onNext(@NonNull final Integer integer) {
        System.out.println("On next: " + integer);
      }

      @Override public void onError(@NonNull final Throwable e) {
        System.out.println("On error: " + e.getMessage());
      }

      @Override public void onComplete() {
        System.out.println("Completed");
      }
    };

    source.subscribe(observer);

  }

}
