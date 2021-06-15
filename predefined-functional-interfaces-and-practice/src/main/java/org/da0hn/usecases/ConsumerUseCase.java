package org.da0hn.usecases;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class ConsumerUseCase {

  public static void main(String[] args) {
    var intList = List.of(34, 67, 8, 23, 67, 89, 90);

    Consumer<Integer> consumer = e -> System.out.println(e);

    printElements(consumer, intList);

  }

  private static <T> void printElements(Consumer<T> consumer, List<T> list) {
    for(T t : list) {
      consumer.accept(t);
    }
  }


}
