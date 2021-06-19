package org.da0hn.usecases;

import org.da0hn.usecases.concepts.lambdas.FunctionalGenerics;

/**
 * Created by daohn on 14/06/2021
 * @author daohn
 * @since 14/06/2021
 */
public class FunctionalGenericUseCase {

  public static void main(String[] args) {
    FunctionalGenerics<String, String> fn = s -> s.substring(1, 2);
    System.out.println(fn.execute("Da0hn"));

    FunctionalGenerics<String, Integer> fn2 = s -> s.length();
    System.out.println(fn2.execute("da0hn"));
  }

}
