package org.da0hn.codestyleprogramming;

import java.util.stream.IntStream;

/**
 * Created by daohn on 04/04/2021
 * @author daohn
 * @since 04/04/2021
 * @version 1.0.0
 */
public class ImperativeVsDeclarative {

  public static void main(String[] args) {
    imperativeStyle();
    declarativeStyle();
  }

  private static void declarativeStyle() {
    // var sum = IntStream.rangeClosed(0, 99).filter(number % 2 == 0).reduce(Integer::sum).getAsInt();
    var sumOfEvens = IntStream.rangeClosed(0, 100)
                       .filter(number -> number % 2 == 0)
                       .sum();
    System.out.println(sumOfEvens);
  }

  private static void imperativeStyle() {
    int sumOfEvens = 0;
    for(int i = 0; i <= 100; i++) {
      if(i % 2 == 0) {
        sumOfEvens += i;
      }
    }
    System.out.println(sumOfEvens);
  }

}
