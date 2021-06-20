package com.da0hn.usecases.factory;

import java.util.function.Supplier;

/**
 * @author daohn
 * @since 20/06/2021
 */
class FlooringFactory {

  public static Flooring getFlooring(int minimumTemperature, int maximumTemperature) {

    Supplier<Flooring> flooring;

    if(minimumTemperature <= 5 && maximumTemperature <= 20) {
      flooring = () -> new WoodenFlooring();
    }
    else if(minimumTemperature <= 5 && maximumTemperature >= 45) {
      flooring = () -> new CorkFlooring();
    }
    else {
      flooring = () -> new ConcreteFlooring();
    }

    return flooring.get();
  }

}
