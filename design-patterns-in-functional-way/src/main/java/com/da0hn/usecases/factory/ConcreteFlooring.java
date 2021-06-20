package com.da0hn.usecases.factory;

/**
 * @author daohn
 * @since 20/06/2021
 */
class ConcreteFlooring implements Flooring{
  @Override public void installation() {
    System.out.println("The Concrete flooring is installed!");
  }
}
