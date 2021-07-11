package org.da0hn.usecases;

import org.da0hn.domain.Employee;
import org.da0hn.utils.EmployeeDataFactory;

import java.util.stream.Collectors;

/**
 * @author daohn
 * @since 10/07/2021
 */
public class TerminalAnalogousCollectorsOneUseCase {

  public static void main(String[] args) {
    var employees = EmployeeDataFactory.create();

    var names = employees.stream()
      .map(Employee::name)
      .collect(Collectors.toList());

    names.forEach(System.out::println);

    var designations = employees.stream().map(Employee::designation).collect(Collectors.toSet());

    designations.forEach(System.out::println);

  }

}
