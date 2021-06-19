package org.da0hn.usecases;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class ImpureFunctionUseCase {

  private int value = 0;

  /**
   * Change state of {@link ImpureFunctionUseCase#value}. <br>
   * Is a impure function.
   * @param nextValue value will be sum in {@link ImpureFunctionUseCase#value}
   * @return sum of {@link ImpureFunctionUseCase#value} with nextValue
   */
  public int add(int nextValue) {
    this.value += nextValue;
    return this.value;
  }

}
