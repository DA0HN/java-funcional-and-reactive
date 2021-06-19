package org.da0hn.usecases.concepts;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class ReferencialTransparencyUseCase {

  public static void main(String[] args) {
    int result = add(2, multiply(2, 4));

    int sameResult = add(2, multiply(2, multiply(2, 2)));

    System.out.println(result);

    System.out.println(sameResult);
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static int multiply(int a, int b) {
    System.out.println("Multiplying 'a' and 'b': " + a + ", " + b);
    return a * b;
  }


}
