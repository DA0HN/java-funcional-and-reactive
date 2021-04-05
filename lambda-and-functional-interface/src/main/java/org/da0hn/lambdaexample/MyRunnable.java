package org.da0hn.lambdaexample;

/**
 * Created by daohn on 04/04/2021
 * @author daohn
 * @since 04/04/2021
 * @version 1.0.0
 */
public class MyRunnable implements Runnable {

  @Override public void run() {
    System.out.println("Thread Executed!");
  }
}
