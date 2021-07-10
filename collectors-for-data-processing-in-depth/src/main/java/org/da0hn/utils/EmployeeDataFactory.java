package org.da0hn.utils;

import org.da0hn.domain.Employee;
import org.da0hn.usecases.CollectorsInActionUseCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author daohn
 * @since 10/07/2021
 */
public class EmployeeDataFactory {

  private static final String FILE_NAME = "employees.txt";

  // https://howtodoinjava.com/java/io/read-file-from-resources-folder/
  public static List<Employee> create() {
    var loader = CollectorsInActionUseCase.class.getClassLoader();
    var path = new File(Objects.requireNonNull(loader.getResource(FILE_NAME)).getFile()).toPath();

    try(Stream<String> lines = Files.lines(path)) {

      var parsedLineStream = lines.flatMap(line -> Arrays.stream(line.split(",")));

      var employeeSpliterator = new EmployeeSpliterator(parsedLineStream.spliterator());

      return StreamSupport.stream(employeeSpliterator, false).collect(Collectors.toList());
    }
    catch(IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Error in stream creation");
    }
  }

}
