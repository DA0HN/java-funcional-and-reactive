package org.da0hn.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class UnaryOperatorUseCase {

  public static void main(String[] args) {

    List<Integer> list = List.of(10, 20, 30, 40, 50);
    UnaryOperator<Integer> operator = i -> i * 100;

    List<Integer> newList = mapper(list, operator);

    System.out.println(newList);

  }

  private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {

    var newList = new ArrayList<T>();

    for(T t : list) {
      newList.add(operator.apply(t));
    }

    return newList;
  }

}
