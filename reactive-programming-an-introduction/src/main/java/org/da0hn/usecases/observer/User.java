package org.da0hn.usecases.observer;

/**
 * @author daohn
 * @since 13/07/2021
 */
record User(
  String name
) implements IObserver {

  public User(String name, ISubject library) {
    this(name);
    library.subscribe(this);
  }

  @Override public void update(String available) {
    System.out.println("Hello " + name + "! We are glad to notify you that your book is now " + available);
  }
}
