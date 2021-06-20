package com.da0hn.usecases.decorator;

/**
 * @author daohn
 * @since 20/06/2021
 */
class DecoratorUseCase {

  public static void main(String[] args) {
    var myOrder = new BurgerShop(Burger::addCheese).use(
      new BurgerShop(Burger::addVegies).use(new Burger()
      )
    );

    System.out.println("I get: " + myOrder);
  }

}
