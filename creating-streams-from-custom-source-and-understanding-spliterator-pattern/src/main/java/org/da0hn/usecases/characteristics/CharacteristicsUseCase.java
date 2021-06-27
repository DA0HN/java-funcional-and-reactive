package org.da0hn.usecases.characteristics;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * @author daohn
 * @since 27/06/2021
 */
public class CharacteristicsUseCase {

  public static void main(String[] args) {

    var list = new ArrayList<Integer>();
    list.add(4);
    list.add(7);
    list.add(9);
    list.add(0);
    list.add(1);

    Stream<Integer> stream = list.stream();
    Spliterator<Integer> spliterator = stream.spliterator();
    int bits = spliterator.characteristics();

    System.out.println(Integer.bitCount(bits));

    // OR

    System.out.println(Integer.bitCount(bits | 0x00000010));

    // AND

    System.out.println(bits & 0x00000010);

    System.out.println(spliterator.hasCharacteristics(0x0000_0010));
  }

}
