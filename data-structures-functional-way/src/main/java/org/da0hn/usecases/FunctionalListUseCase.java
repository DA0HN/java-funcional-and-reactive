package org.da0hn.usecases;

import org.da0hn.collections.functinal.FunctionalList;

import java.util.List;

final class FunctionalListUseCase {

  public static void main(final String[] args) {
    final var list = FunctionalList.list(1, 2, 3);
    forEach(list);

    final var newList = list.add(56);
    forEach(newList);

    final var newListRemovedElement3 = newList.remove(3);
    forEach(newListRemovedElement3);

    final var newReverseList = newListRemovedElement3.reverse();
    forEach(newReverseList);

    final var newListConcat = FunctionalList.concat(newReverseList, list);
    forEach(newListConcat);

    final var integers = List.of(2, 0, 9);
    final var newListOfAddAll = newListConcat.addAll(integers);
    forEach(newListOfAddAll);
  }

  private static <T> void forEach(final FunctionalList<T> newList) {
    newList.forEach(System.out::println);
    System.out.println();
  }

}
