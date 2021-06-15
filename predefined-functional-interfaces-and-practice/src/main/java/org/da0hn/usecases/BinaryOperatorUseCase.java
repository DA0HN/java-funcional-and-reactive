package org.da0hn.usecases;

import java.util.function.BinaryOperator;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class BinaryOperatorUseCase {

  public static void main(String[] args) {

    BinaryOperator<String> operator = (a, b) -> a + "." + b;

    var resultString = operator.apply("aaa","bbbb");

    System.out.println(resultString);
  }

}
