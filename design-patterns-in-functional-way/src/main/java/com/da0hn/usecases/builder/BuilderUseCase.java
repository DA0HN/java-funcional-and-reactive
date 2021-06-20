package com.da0hn.usecases.builder;

/**
 * @author daohn
 * @since 20/06/2021
 */
class BuilderUseCase {

  public static void main(String[] args) {

    var builder = new MobileBuilder();

    var mobile = builder.with(
      b -> {
        b.setRam(4);
        b.setBattery(4000);
        b.setProcessor("A12 Bionic");
      }
    ).create();

    System.out.println(mobile);

  }

}
