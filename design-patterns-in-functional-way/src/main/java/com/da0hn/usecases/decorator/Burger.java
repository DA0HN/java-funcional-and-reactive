package com.da0hn.usecases.decorator;

/**
 * @author daohn
 * @since 20/06/2021
 */
class Burger {

  private String type;

  public Burger() {
    this.type = "";
  }

  private Burger(String type) {
    this.type = type;
  }

  public Burger addVegies() {
    System.out.println("Adding veggies to the burger");
    return new Burger(this.type += " Veggie");
  }

  public Burger addCheese() {
    System.out.println("Adding cheese to the burger");
    return new Burger(this.type += " Cheese");
  }

  @Override public String toString() {
    return String.format("%s",type + " burger");
  }
}
