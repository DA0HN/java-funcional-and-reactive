package org.da0hn.usecases;

import org.da0hn.collections.functinal.FunctionalMap;

final class FunctionalMapUseCase {

  public static void main(final String[] args) {
    final var map = new FunctionalMap<Integer, String>(5);
    map.put(1, "Nikhil");
    map.put(2, "Gabriel");
    map.put(3, "Daniel");
  }

}
