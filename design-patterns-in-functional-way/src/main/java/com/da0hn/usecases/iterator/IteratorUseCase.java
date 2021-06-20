package com.da0hn.usecases.iterator;

/**
 * @author daohn
 * @since 20/06/2021
 */
public class IteratorUseCase {

  public static void main(String[] args) {
    ArrayList list = new ArrayList(new Object[]{1, 2, 3, 4, 5});

    list.forEach(System.out::println);
  }

}
