package org.da0hn.usecases;

import org.da0hn.domain.Employee;
import org.da0hn.utils.EmployeeDataFactory;
import org.da0hn.utils.Print;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author daohn
 * @since 10/07/2021
 */
public class TerminalAnalogousCollectorsTwoUseCase {

  public static void main(String[] args) {

    var employees = EmployeeDataFactory.create();

    treeSet(employees);

    map(employees);

    partitioningByGender(employees);

    groupedByDesignation(employees);

  }

  private static void groupedByDesignation(List<Employee> employees) {
    Map<String, List<Employee>> employeesGroupedByDesignation = employees.stream().collect(
      Collectors.groupingBy(Employee::designation));

    var architectsEmployees = employeesGroupedByDesignation.get("Architect");
    var developersEmployees = employeesGroupedByDesignation.get("Developer");
    // ...

    Print.map(employeesGroupedByDesignation);
  }

  private static void partitioningByGender(List<Employee> employees) {
    Map<Boolean, List<Employee>> partitionedEmployeesByGender = employees.stream()
      .collect(Collectors.partitioningBy(e -> e.gender() == 'M'));
    Print.map(partitionedEmployeesByGender);

    var maleEmployees = partitionedEmployeesByGender.get(false);
    var femaleEmployees = partitionedEmployeesByGender.get(true);

  }

  private static void map(List<Employee> employees) {
    Map<Integer, String> getNameById = employees.stream()
      .collect(Collectors.toMap(
        Employee::id, Employee::name
      ));

    Print.map(getNameById);
  }

  private static void treeSet(List<Employee> employees) {
    var employeesSorted = employees.stream()
      .collect(Collectors.toCollection(TreeSet::new));

    employeesSorted.forEach(System.out::println);
  }


}
