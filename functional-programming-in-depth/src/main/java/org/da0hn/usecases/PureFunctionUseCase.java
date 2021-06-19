package org.da0hn.usecases;

import static java.lang.String.format;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class PureFunctionUseCase {


  public static void main(String[] args) {

    var result = sum(multiply(2, 3), multiply(3, 4));

    System.out.println(result);
  }

  /**
   *
   * @param a first number
   * @param b second number
   * @return Multiplication of first and second number
   */
  public static int multiply(int a, int b) {
    log(format("Returning %s as the result of %s * %s", a * b, a, b));
    return a * b;
  }

  /**
   * Show message in console.
   * @param message Information that will be presented.
   */
  public static void log(String message) {
    System.out.println(message);
  }

  /**
   * Don't have side effects. <br>
   * Does not change the state within the function.
   * @param a first number
   * @param b second number
   * @return sum of first and second numbers.
   */
  public static int sum(int a, int b) {
    return a + b;
  }


}
