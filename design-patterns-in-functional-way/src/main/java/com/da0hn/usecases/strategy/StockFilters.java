package com.da0hn.usecases.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author daohn
 * @since 20/06/2021
 */
class StockFilters {

  public static List<Stock> bySymbol(List<Stock> stocks, String symbol) {
    List<Stock> filteredData = new ArrayList<>();

    for(var stock : stocks) {
      if(stock.symbol().equals(symbol)) {
        filteredData.add(stock);
      }
    }

    return filteredData;
  }

  public static List<Stock> byPriceAbove(List<Stock> stocks, double price) {
    List<Stock> filteredData = new ArrayList<>();

    for(var stock : stocks) {
      if(stock.price() > price) {
        filteredData.add(stock);
      }
    }

    return filteredData;
  }


  public static List<Stock> filter(List<Stock> stocks, Predicate<Stock> condition) {
    List<Stock> filteredData = new ArrayList<>();

    for(var stock : stocks) {
      if(condition.test(stock)) {
        filteredData.add(stock);
      }
    }

    return filteredData;
  }
}
