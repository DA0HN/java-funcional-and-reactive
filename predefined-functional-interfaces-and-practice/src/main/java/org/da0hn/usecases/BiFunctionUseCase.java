package org.da0hn.usecases;

import java.util.function.BiFunction;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class BiFunctionUseCase {

  public static void main(String[] args) {

    BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();

    var lengthOfConcatString = biFunction.apply("aaa", "bbbb");

    System.out.println(lengthOfConcatString);
  }

}
