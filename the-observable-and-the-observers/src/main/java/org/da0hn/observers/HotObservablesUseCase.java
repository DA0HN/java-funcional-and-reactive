package org.da0hn.observers;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

final class HotObservablesUseCase {

  public static void main(final String[] args) throws InterruptedException {

    final var source = Observable.interval(1, TimeUnit.SECONDS).publish();

    source.connect();

    source.subscribe(System.out::println);

    Thread.sleep(10000);

    source.subscribe(System.out::println);

    Thread.sleep(10000);

  }


}
