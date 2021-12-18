package org.da0hn.collections.functinal;

import java.util.function.Consumer;

public class FunctionalQueue<T> {

  private final FunctionalList<T> front;
  private final FunctionalList<T> rear;

  public FunctionalQueue() {
    this.front = FunctionalList.list();
    this.rear = FunctionalList.list();
  }

  private FunctionalQueue(final FunctionalQueue<T> queue, final T element) {
    final boolean frontIsEmpty = queue.front.isEmpty();
    this.front = frontIsEmpty ? queue.front.add(element) : queue.front;
    this.rear = frontIsEmpty ? queue.rear : queue.rear.add(element);
  }

  private FunctionalQueue(final FunctionalList<T> front, final FunctionalList<T> rear) {
    final var frontIsEmpty = front == null || front.isEmpty();
    this.front = frontIsEmpty ? rear.reverse() : front;
    this.rear = frontIsEmpty ? front : rear;
  }

  public static <T> FunctionalQueue<T> queue() {
    return new FunctionalQueue<>();
  }

  public FunctionalQueue<T> enqueue(final T element) {
    return new FunctionalQueue<>(this, element);
  }

  public FunctionalQueue<T> dequeue() {
    return new FunctionalQueue<>(this.front.tail(), this.rear);
  }

  public void forEach(final Consumer<? super T> action) {
    T current = this.front.head();
    var tempList = FunctionalList.concat(this.front.tail(), this.rear.reverse());
    while(tempList != null) {
      action.accept(current);
      current = tempList.head();
      tempList = tempList.tail();
    }
  }

  public T peek() {
    if(this.length() == 0) {
      return null;
    }
    return this.front.head();
  }

  public int length() {
    return this.front.length() + this.rear.length();
  }

  public boolean isEmpty() {
    return this.frontIsEmpty() && this.rearIsEmpty();
  }

  private boolean rearIsEmpty() {
    return this.rear == null || this.rear.isEmpty();
  }

  private boolean frontIsEmpty() {
    return this.front == null || this.front.isEmpty();
  }

}
