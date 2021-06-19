package org.da0hn.usecases.techniques;

import org.da0hn.usecases.techniques.lambdas.IFunction;
import org.da0hn.usecases.techniques.model.Square;


/**
 * @author daohn
 * @since 19/06/2021
 */
public class FunctionalCompositionUseCase {

  public static void main(String[] args) {

    /**
     *
     * R fn1(T t) -> U fn2(R r)
     * fn1(Square) : Integer ->  fn2(Integer) : Double
     * fn2(fn1)
     * T -> R -> U
     *
     * square(square) -> area(int) -> sqrt(double)
     *
     */
    IFunction<Square, Integer> fn1 = square -> square.area(); // Square::area
    IFunction<Integer, Double> fn2 = area -> Math.sqrt(area); // Math::sqrt

    var getSide = fn2.compose(fn1);

    Double side = getSide.apply(new Square(100));

    System.out.println(side);
  }

}
