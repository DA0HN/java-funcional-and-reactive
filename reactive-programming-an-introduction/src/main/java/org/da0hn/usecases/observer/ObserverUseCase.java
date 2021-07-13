package org.da0hn.usecases.observer;

/**
 * @author daohn
 * @since 13/07/2021
 */
class ObserverUseCase {

  public static void main(String[] args) {

    var book = new Book("Goosebumps","Horror","Xyz",200.0,"SoldOut");

    var userOne = new User("Bob", book);
    var userTwo = new User("Rob", book);

    book = book.updateStock("InStock");

    book.unsubscribe(userOne);

    book.updateStock("SoldOut");
  }

}
