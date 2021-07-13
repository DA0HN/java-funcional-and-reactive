package org.da0hn.usecases.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daohn
 * @since 13/07/2021
 */
record Book(
  String name,
  String type,
  String author,
  Double price,
  String inStock,
  List<IObserver> observers
) implements ISubject {

  public Book(String name, String type, String author, Double price, String inStock) {
    this(name, type, author, price, inStock, new ArrayList<>());
  }

  public Book updateStock(String inStock) {
    System.out.println("Availability changed from Sold out to Back in stock");
    this.notifyObserver();
    return new Book(this.name, this.type, this.author, this.price, inStock, observers);
  }

  @Override public void subscribe(IObserver observer) {
    this.observers.add(observer);
  }

  @Override public void unsubscribe(IObserver observer) {
    this.observers.remove(observer);
  }

  @Override public void notifyObserver() {

    System.out.println(this.name + " in stock!");

    this.observers.forEach(observer -> {
      System.out.println("Notifying observer...");
      observer.update(this.inStock);
    });
  }
}
