package org.da0hn.list;

import java.util.function.Consumer;

abstract class AbstractFunctionalList<T> {

  @SafeVarargs
  public static <T> AbstractFunctionalList<T> list(final T... itens) {
    AbstractFunctionalList<T> list = list();
    for(int i = itens.length - 1; i >= 0; i--) {
      list = new Const<>(itens[i], list);
    }
    return list;
  }

  public static <T> AbstractFunctionalList<T> list() {
    return Nil.getNil();
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

  int length() {
    int lengthCounter = 0;
    var currentTail = this;

    while(!currentTail.equals(Nil.getNil())) {
      lengthCounter++;
      currentTail = currentTail.tail();
    }

    return lengthCounter;
  }

  public abstract AbstractFunctionalList<T> tail();

  public AbstractFunctionalList<T> remove(final T element) {
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

  public AbstractFunctionalList<T> reverse() {
    AbstractFunctionalList<T> list = list();
    T current = this.head();
    var temp = this;

    while(!temp.equals(Nil.getNil())) {
      list = list.add(current);
      temp = temp.tail();
      current = temp.head();
    }

    return list;
  }

  public AbstractFunctionalList<T> add(final T element) {
    return new Const<>(element, this);
  }

  public abstract boolean isEmpty();

  private static final class Nil<T> extends AbstractFunctionalList<T> {

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

    @Override public AbstractFunctionalList<T> tail() {
      return null;
    }

    @Override public boolean isEmpty() {
      return true;
    }
  }

  private static final class Const<T> extends AbstractFunctionalList<T> {

    private final T head;
    private final AbstractFunctionalList<T> tail;

    Const(final T head, final AbstractFunctionalList<T> tail) {
      this.head = head;
      this.tail = tail;
    }

    @Override public T head() {
      return this.head;
    }

    @Override public AbstractFunctionalList<T> tail() {
      return this.tail;
    }

    @Override public boolean isEmpty() {
      return this.length() == 0;
    }
  }
}
