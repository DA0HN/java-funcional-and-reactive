package org.da0hn.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * @author daohn
 * @since 12/07/2021
 */
public class CustomCollectorUseCase {

  public static void main(String[] args) {

    var numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);

    Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(
      ArrayList::new,
      List::add,
      (left, right) -> {
        left.addAll(right);
        return left;
      },
      Collector.Characteristics.IDENTITY_FINISH
    );

    var collect = numbers.stream().filter(e -> e % 2 == 0).collect(toList);

    collect.forEach(System.out::println);

  }

}
