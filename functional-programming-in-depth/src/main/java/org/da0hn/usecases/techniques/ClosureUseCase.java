package org.da0hn.usecases.techniques;

import org.da0hn.usecases.techniques.lambdas.ITask;

/**
 * @author daohn
 * @since 19/06/2021
 */
public class ClosureUseCase {

  public static void main(String[] args) {

    int val = 111;

    ITask lambda = () -> {
      // val = 122; -> cannot be changed

      System.out.println(val);
      System.out.println("Task completed.");
    };

    print(lambda);

  }

  public static void print(ITask task) {
    task.doTask();
  }

}
