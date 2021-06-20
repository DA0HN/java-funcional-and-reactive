package com.da0hn.usecases.strategy;

import java.util.ArrayList;

/**
 * @author daohn
 * @since 20/06/2021
 */
class StrategyUseCase {

  public static void main(String[] args) {
    var list = new ArrayList<Stock>();

    list.add(new Stock("AAPL", 318.65, 10));
    list.add(new Stock("MSFT", 166.86, 45));
    list.add(new Stock("Google", 99, 12.5));
    list.add(new Stock("AMZ", 1866.74, 45));
    list.add(new Stock("GOOGL", 1480.20, 3.5));
    list.add(new Stock("AAPL", 318.65, 8));
    list.add(new Stock("AMZ", 1866.74, 9));

    StockFilters.bySymbol(list, "AMZ").forEach(System.out::println);

    System.out.println("-".repeat(50));

    StockFilters.byPriceAbove(list, 300).forEach(System.out::println);

    System.out.println("-".repeat(50));

    StockFilters.filter(
      list,
      stock -> stock.symbol().equals("AMZ")
    ).forEach(System.out::println);

    System.out.println("-".repeat(50));

    StockFilters.filter(
      list,
      stock -> stock.price() > 300
    ).forEach(System.out::println);

  }

}
