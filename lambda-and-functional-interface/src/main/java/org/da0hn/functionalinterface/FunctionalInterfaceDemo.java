package org.da0hn.functionalinterface;

/**
 * Created by daohn on 04/04/2021
 * @author daohn
 * @since 04/04/2021
 * @version 1.0.0
 */
public class FunctionalInterfaceDemo {
  public static void main(String[] args) {
    //    MyFunctionalInterface functionalInterface = () -> System.out.println("Hello!");
    //    functionalInterface.myMethod();
    //    Integer x = 100;
    onTheFly(() -> System.out.println("Hello!"));
  }

  /**
   * Fornece a implementação de uma função em tempo de compilação
   * @param function ação que será executada durante a função.
   */
  public static void onTheFly(MyFunctionalInterface function) {
    function.myMethod();
  }
}
