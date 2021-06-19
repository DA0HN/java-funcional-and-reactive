package org.da0hn.usecases.techniques;

import java.util.function.Function;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class CurryingUseCase {

  public static void main(String[] args) {

    Function<Integer, Function<Integer, Integer>> fn = u -> v -> u + v;

    Function<Integer, Integer> fn2 = fn.apply(10);

    var result = fn2.apply(3);

    System.out.println(result);
  }

}
