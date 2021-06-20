package com.da0hn.usecases.decorator;

import java.util.function.Function;

/**
 * @author daohn
 * @since 20/06/2021
 */
class BurgerShop {

  private Function<Burger, Burger> decoration;

  public BurgerShop(Function<Burger, Burger> decoration) {
    this.decoration = decoration;
  }

  public Burger use(Burger baseBurger) {
    System.out.println("Base Burger: " + baseBurger);
    return decoration.apply(baseBurger);
  }

}
