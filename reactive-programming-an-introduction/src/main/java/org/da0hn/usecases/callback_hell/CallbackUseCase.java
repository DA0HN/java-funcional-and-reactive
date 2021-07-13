package org.da0hn.usecases.callback_hell;

import java.util.concurrent.TimeUnit;

/**
 * @author daohn
 * @since 13/07/2021
 */
class CallbackUseCase {

  public static void main(String[] args) {

    System.out.println("Main thread is running.");

    Runnable r = () -> {
      new CallbackUseCase().runningAsync(() -> {
        System.out.println("Callback called!");
      });
    };

    new Thread(r).start();

    sleep(2000);

    System.out.println("Main thread completed.");
  }

  public void runningAsync(ICallback callback) {
    System.out.println("I am running in separate thread.");
    sleep(1000);
    callback.call();
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
