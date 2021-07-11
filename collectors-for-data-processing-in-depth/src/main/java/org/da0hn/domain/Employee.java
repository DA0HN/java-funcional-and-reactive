package org.da0hn.domain;

import java.time.LocalDate;

/**
 * @author daohn
 * @since 10/07/2021
 */
public record Employee(
  Integer id,
  String name,
  Character gender,
  LocalDate dob,
  String city,
  String designation,
  LocalDate joiningDate,
  Double salary
) implements Comparable<Employee> {
  @Override public int compareTo(Employee o) {
//    if(this.id < o.id()) {
//      return -1;
//    }
//    else if(this.id > o.id()) {
//      return 1;
//    }
//    else {
//      return 0;
//    }
    return this.id.compareTo(o.id());
  }
}
