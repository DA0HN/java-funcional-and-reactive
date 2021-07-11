package org.da0hn.usecases;

import org.da0hn.domain.Employee;
import org.da0hn.utils.EmployeeDataFactory;

import java.util.stream.Collectors;

/**
 * @author daohn
 * @since 10/07/2021
 */
public class CollectorsJoiningUseCase {

  public static void main(String[] args) {

    var employees = EmployeeDataFactory.create();

    var joinedEmployeeName = employees.stream().map(Employee::name).collect(Collectors.joining(","));

    System.out.println(joinedEmployeeName);

  }

}
