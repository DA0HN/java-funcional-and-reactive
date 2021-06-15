package org.da0hn.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by daohn on 15/06/2021
 * @author daohn
 * @since 15/06/2021
 */
public class PredicateUseCase {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("aaabb");
    list.add("");
    list.add("baabb");
    list.add("");
    list.add("cbbcc");
    list.add("dabdd");
    list.add("");

    Predicate<String> ifEmpty = s -> !s.isEmpty();

    var filteredList = filter(ifEmpty, list);

    Predicate<String> ifContains = s -> s.contains("aa");

    filteredList = filter(ifContains, filteredList);

    System.out.println(filteredList);

    List<Integer> intList = List.of(1, 4, 6, 7, 8);

    Predicate<Integer> ifEven = integer -> integer % 2 == 0;

    var filteredIntList = filter(ifEven, intList);

    System.out.println(filteredIntList);
  }

  private static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
    List<T> newList = new ArrayList<>();

    for(var str : list) {
      if(predicate.test(str)) {
        newList.add(str);
      }
    }

    return newList;
  }

}
