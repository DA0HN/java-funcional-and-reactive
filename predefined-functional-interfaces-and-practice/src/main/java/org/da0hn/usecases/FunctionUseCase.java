package org.da0hn.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author daohn
 * @since 15/06/2021
 */
public class FunctionUseCase {

  public static void main(String[] args) {

    var list = List.of("Kit", "Kat", "Shake");

    Function<String, Integer> function = (str) -> str.length();

    List<Integer> newList = map(function, list);

    System.out.println(newList);

  }

  private static <T, R> List<R> map(Function<T, R> function, List<T> list) {
    var newList = new ArrayList<R>();

    for(T t : list) {
      newList.add(function.apply(t));
    }

    return newList;
  }

}
