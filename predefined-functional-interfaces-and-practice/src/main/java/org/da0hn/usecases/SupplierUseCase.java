package org.da0hn.usecases;

import java.util.function.Supplier;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class SupplierUseCase {

  public static void main(String[] args) {

    Supplier<String> stringSupplier = () -> "A String";

    System.out.println(stringSupplier.get());

    Supplier<Double> randomNumber = () -> Math.random();

    System.out.println(randomNumber.get());
  }

}
