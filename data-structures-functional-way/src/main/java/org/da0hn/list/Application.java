package org.da0hn.list;

public final class Application {

  public static void main(final String[] args) {
    final var list = AbstractFunctionalList.list(1, 2, 3);
    list.forEach(System.out::println);
  }

}
