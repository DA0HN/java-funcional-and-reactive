package com.da0hn.usecases.iterator;

import java.util.function.Consumer;

/**
 * @author daohn
 * @since 20/06/2021
 */
public class ArrayList {

  Object[] elements = new Object[5];

  public ArrayList() {
  }

  public ArrayList(Object[] elements) {
    this.elements = elements;
  }

  public void forEach(Consumer<Object> action) {
    for(int i = 0; i < elements.length; i++) {
      action.accept(elements[i]);
    }
  }

}
