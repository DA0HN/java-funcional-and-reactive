package org.da0hn.usecases;

import org.da0hn.domain.Employee;
import org.da0hn.utils.EmployeeDataFactory;
import org.da0hn.utils.Print;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * @author daohn
 * @since 11/07/2021
 */
public class DownstreamCollectorsUseCase {

  public static void main(String[] args) {
    var employees = EmployeeDataFactory.create();

    countEmployeeByDesignation(employees);
    fundDistributedToEmployeeByDesignation(employees);
    maxSalaryEmployeeByDesignation(employees);
    maxSalaryAmountByDesignation(employees);

  }

  private static void maxSalaryAmountByDesignation(List<Employee> employees) {
    Map<String, Optional<Double>> maxSalaryAmountByDesignation = employees.stream().collect(
      groupingBy(
        Employee::designation,
        mapping(
          Employee::salary,
          maxBy(Comparator.comparing(Function.identity()))
        )
      ));

    Print.map(maxSalaryAmountByDesignation);
  }

  private static void maxSalaryEmployeeByDesignation(List<Employee> employees) {
    Map<String, Optional<Employee>> maxSalaryEmployeeByDesignation = employees.stream().collect(groupingBy(
      Employee::designation,
      maxBy(Comparator.comparing(Employee::salary))
    ));

    Print.map(maxSalaryEmployeeByDesignation);
  }

  private static void fundDistributedToEmployeeByDesignation(List<Employee> employees) {
    Map<String, Double> fundDistributionByDesignation = employees.stream().collect(groupingBy(
      Employee::designation,
      summingDouble(Employee::salary)
    ));

    Print.map(fundDistributionByDesignation);
  }

  private static void countEmployeeByDesignation(List<Employee> employees) {
    Map<String, Long> countByDesignation = employees.stream()
      .collect(groupingBy(
        Employee::designation,
        counting()
      ));

    Print.map(countByDesignation);
  }
}
