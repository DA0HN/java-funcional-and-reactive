package com.da0hn.usecases.factory;

/**
 * @author daohn
 * @since 20/06/2021
 */
class FactoryUseCase {

  public static void main(String[] args) {
    Flooring floor = FlooringFactory.getFlooring(13, 48);
    floor.installation();
  }

}
