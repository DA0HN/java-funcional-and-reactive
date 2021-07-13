package org.da0hn.usecases.push_vs_pull;

import java.util.concurrent.TimeUnit;

/**
 * @author daohn
 * @since 13/07/2021
 */
class PushVsPullUseCase {

  public static void main(String[] args) {

    System.out.println("Main thread is running.");

    Runnable r = () -> new PushVsPullUseCase().runningAsync(new ICallback() {
      @Override public void pushData(String data) {
        System.out.println("Callback data: " + data);
      }

      @Override public void pushComplete() {
        System.out.println("Callback done!");
      }

      @Override public void pushError(Exception exception) {
        System.out.println("Callback error called, got an exception: " + exception.getMessage());
      }
    });

    new Thread(r).start();

    sleep(2000);

    System.out.println("Main thread completed.");
  }

  public void runningAsync(ICallback callback) {
    System.out.println("I am running in separate thread.");
    sleep(1000);
    callback.pushData("Data 1");
    callback.pushData("Data 2");
    callback.pushData("Data 3");

    callback.pushError(new RuntimeException("Oops!"));
    callback.pushComplete();
  }

  private static void sleep(int duration) {
    try {
      TimeUnit.MILLISECONDS.sleep(duration);
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

}
