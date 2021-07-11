package org.da0hn.utils;

import java.util.Map;

/**
 * @author daohn
 * @since 11/07/2021
 */
public class Print {

  public static <K, V> void map(Map<K, V> map) {
    map.forEach((k, m) -> System.out.println("[" + k + ", " + m + "]"));
  }


}
