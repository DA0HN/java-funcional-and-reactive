package org.da0hn.utils;

import org.da0hn.domain.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author daohn
 * @since 10/07/2021
 */
public class EmployeeSpliterator implements Spliterator<Employee> {

  private Integer id;
  private String name;
  private Character gender;
  private LocalDate dob;
  private String city;
  private String designation;
  private LocalDate joiningDate;
  private Double salary;

  private final Spliterator<String> lineSpliterator;

  private final static long FIELDS_NUMBER = 8;
  private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yy");

  public EmployeeSpliterator(Spliterator<String> lineSpliterator) {
    this.lineSpliterator = lineSpliterator;
  }

  @Override public boolean tryAdvance(Consumer<? super Employee> action) {

    if(
      this.lineSpliterator.tryAdvance(id -> this.id = Integer.valueOf(id)) &&
      this.lineSpliterator.tryAdvance(name -> this.name = name) &&
      this.lineSpliterator.tryAdvance(gender -> this.gender = gender.charAt(0)) &&
      this.lineSpliterator.tryAdvance(dob -> this.dob = LocalDate.parse(dob, FORMAT)) &&
      this.lineSpliterator.tryAdvance(city -> this.city = city) &&
      this.lineSpliterator.tryAdvance(designation -> this.designation = designation) &&
      this.lineSpliterator.tryAdvance(joiningDate -> this.joiningDate = LocalDate.parse(joiningDate, FORMAT)) &&
      this.lineSpliterator.tryAdvance(salary -> this.salary = Double.parseDouble(salary))
    ) {
      action.accept(new Employee(id, name, gender, dob, city, designation, joiningDate, salary));
      return true;
    }

    return false;
  }

  @Override public Spliterator<Employee> trySplit() {
    return null;
  }

  @Override public long estimateSize() {
    return this.lineSpliterator.estimateSize() / FIELDS_NUMBER;
  }

  @Override public int characteristics() {
    return this.lineSpliterator.characteristics();
  }
}
