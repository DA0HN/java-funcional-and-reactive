package org.da0hn.collections.functinal;

import java.util.function.Consumer;

public abstract class FunctionalList<T> {

  @SafeVarargs
  public static <T> FunctionalList<T> list(final T... itens) {
    FunctionalList<T> list = list();
    for(int i = itens.length - 1; i >= 0; i--) {
      list = new Const<>(itens[i], list);
    }
    return list;
  }

  public static <T> FunctionalList<T> list() {
    return Nil.getNil();
  }

  public static <T> FunctionalList<T> concat(
    final FunctionalList<T> list1,
    final FunctionalList<T> list2
  ) {
    return list1.isEmpty()
      ? list2
      : new Const<>(list1.head(), concat(list1.tail(), list2));
  }

  public FunctionalList<T> addAll(final Iterable<T> anotherList) {
    FunctionalList<T> result = this;
    for(final T element : anotherList) {
      result = result.add(element);
    }
    return result;
  }

  public FunctionalList<T> add(final T element) {
    return new Const<>(element, this);
  }

  public void forEach(final Consumer<? super T> action) {
    T current = this.head();
    var temp = this;

    for(int i = 0; i < this.length(); i++) {
      action.accept(current);
      temp = temp.tail();
      current = temp.head();
    }

  }

  public abstract T head();

  public int length() {
    int lengthCounter = 0;
    var currentTail = this;

    while(!currentTail.equals(Nil.getNil())) {
      lengthCounter++;
      currentTail = currentTail.tail();
    }

    return lengthCounter;
  }

  public FunctionalList<T> remove(final T element) {
    if(this.length() == 0) {
      return this;
    }

    if(element.equals(this.head())) {
      return this.tail();
    }

    final var newTail = this.tail().remove(element);

    if(newTail.equals(this.tail())) {
      return this;
    }

    return new Const<>(this.head(), newTail);
  }

  public FunctionalList<T> reverse() {
    FunctionalList<T> list = list();
    T current = this.head();
    var temp = this;

    while(!temp.equals(Nil.getNil())) {
      list = list.add(current);
      temp = temp.tail();
      current = temp.head();
    }

    return list;
  }

  public abstract FunctionalList<T> tail();

  public abstract boolean isEmpty();

  private static final class Nil<T> extends FunctionalList<T> {

    private static Nil<?> nil;

    static <T> Nil<T> getNil() {
      if(nil == null) {
        nil = new Nil<T>();
      }
      return (Nil<T>) nil;
    }

    @Override public T head() {
      return null;
    }

    @Override public FunctionalList<T> tail() {
      return null;
    }

    @Override public boolean isEmpty() {
      return true;
    }
  }

  private static final class Const<T> extends FunctionalList<T> {

    private final T head;
    private final FunctionalList<T> tail;

    Const(final T head, final FunctionalList<T> tail) {
      this.head = head;
      this.tail = tail;
    }

    @Override public T head() {
      return this.head;
    }

    @Override public FunctionalList<T> tail() {
      return this.tail;
    }

    @Override public boolean isEmpty() {
      return this.length() == 0;
    }
  }
}
