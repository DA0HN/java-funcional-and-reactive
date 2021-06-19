package org.da0hn.usecases.techniques;

import org.da0hn.usecases.techniques.lambdas.IConsumer;

import java.util.function.Function;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class MethodChainingUseCase {

  public static void main(String[] args) {
    IConsumer<String> consumerOne = System.out::println;  // same (str) -> sout(str);
    IConsumer<String> consumerTwo = System.out::println;

    IConsumer<String> consumerThree = str -> {
      consumerOne.accept(str);
      consumerTwo.accept(str);
    };

    consumerThree.accept("hello");

    IConsumer<String> consumerFour = consumerOne.thenAccept(consumerTwo);

    consumerFour.accept("hello 2");

    Function<Integer, Integer> fn1 = num -> num + 2;
    Function<Integer, Integer> fn2 = num -> num * 2;

    Function<Integer, Integer> fn3 = fn1.andThen(fn2);

    System.out.println(fn3.apply(10));

  }


}
