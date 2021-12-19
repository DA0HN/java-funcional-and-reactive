package org.da0hn.observers;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

final class ColdObservablesUseCase {

  public static void main(final String[] args) {

    var list = new ArrayList<Integer>();

    list.add(16);
    list.add(18);
    list.add(99);

    final var source = Observable.fromIterable(list);

    list = updateList(list);

    source.subscribe(System.out::println);

    list.add(15); // not printed, cold observable

  }

  private static ArrayList<Integer> updateList(final ArrayList<Integer> list) {
    list.add(19);
    return list;
  }

}
