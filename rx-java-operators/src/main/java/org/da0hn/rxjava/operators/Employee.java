package org.da0hn.rxjava.operators;

class Employee {

  private int id;
  private String name;
  private double salary;
  private double rating;

  public Employee(final int id, final String name, final double salary, final double rating) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.rating = rating;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public double getSalary() {
    return this.salary;
  }

  public void setSalary(final double salary) {
    this.salary = salary;
  }

  public double getRating() {
    return this.rating;
  }

  public void setRating(final double rating) {
    this.rating = rating;
  }

  @Override public String toString() {
    return "Employee{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", salary=" + salary +
           ", rating=" + rating +
           '}';
  }
}
