package org.da0hn.list;

public final class Application {

  public static void main(final String[] args) {
    final var list = AbstractFunctionalList.list(1, 2, 3);
    forEach(list);

    final var newList = list.add(56);
    forEach(newList);

    final var newListRemovedElement3 = newList.remove(3);
    forEach(newListRemovedElement3);

    final var newReverseList = newListRemovedElement3.reverse();
    forEach(newReverseList);

    final var newListConcat = AbstractFunctionalList.concat(newReverseList, list);
    forEach(newListConcat);

  }

  private static <T> void forEach(final AbstractFunctionalList<T> newList) {
    newList.forEach(System.out::println);
    System.out.println();
  }

}
