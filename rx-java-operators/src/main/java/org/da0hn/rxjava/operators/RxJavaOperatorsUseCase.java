package org.da0hn.rxjava.operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;
import java.util.List;

final class RxJavaOperatorsUseCase {

  public static void main(final String[] args) {

    final Observable<Employee> employees = Observable.just(
      new Employee(101, "Alexa", 60000, 4.0),
      new Employee(123, "Dhwanit", 94000, 4.7),
      new Employee(236, "Mike", 65000, 4.0),
      new Employee(155, "Ella", 85000, 4.4),
      new Employee(443, "George", 50000, 3.6),
      new Employee(127, "Shreeja", 85000, 4.5),
      new Employee(509, "Daniel", 60000, 4.0),
      new Employee(344, "Lucy", 94000, 4.7),
      new Employee(509, "Harry", 75000, 4.3),
      new Employee(344, "Emma", 55000, 3.7)
    );

    employees
      .filter(e -> e.getRating() > 4.0)
      .sorted(Comparator.comparingDouble(Employee::getRating))
      .map(Employee::getName)
      .take(4)
      .toList()
      .subscribe(System.out::println);

    final var expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 789);

    Observable.fromIterable(expenses)
      .reduce(Integer::sum)
      .subscribe(System.out::println);

  }

}
