package org.da0hn.usecases;

import org.da0hn.lambda.MathOperation;

/**
 * Created by daohn on 14/06/2021
 * @author daohn
 * @since 14/06/2021
 */
public class WithParameterAndNoReturnType {

  public static void main(String[] args) {

    MathOperation add = (a, b) -> System.out.println(a + b);

    add.operation(1, 3);

    MathOperation multiply = (a, b) -> System.out.println(a * b);

    multiply.operation(3, 5);

  }

}
