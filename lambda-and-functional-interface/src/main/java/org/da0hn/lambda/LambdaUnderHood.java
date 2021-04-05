package org.da0hn.lambda;

import org.da0hn.functionalinterface.MyFunctionalInterface;

/**
 * Created by daohn on 04/04/2021
 * @author daohn
 * @since 04/04/2021
 * @version 1.0.0
 */
public class LambdaUnderHood {

  public static void main(String[] args) {

    MyFunctionalInterface fn1 = new MyFunctionalInterface() {
      @Override public void myMethod() {
        System.out.println("Implementation 1");
      }
    };

    MyFunctionalInterface fn2 = new MyFunctionalInterface() {
      @Override public void myMethod() {
        System.out.println("Implementation 2");
      }
    };

    /*
     * Lambdas usam inferência de tipo para invocar dinamicamente as funções
     */
    MyFunctionalInterface fn3 = () -> System.out.println("I'm light weight");
  }

}
