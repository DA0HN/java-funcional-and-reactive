package org.da0hn.usecases.techniques;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class TailCallOptimizationUseCase {

  public static void main(String[] args) {

  }

  public static long reFact(int n) {
    if(n <= 1) {
      return 1;
    }
    return n * reFact(n - 1);
  }

  public static long tailReFact(int n, int a) {

    if(n <= 1) {
      return a;
    }

    return tailReFact(n - 1, n * a);
  }

}
