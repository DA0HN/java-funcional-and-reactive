package org.da0hn.lambdaexample;

/**
 * Created by daohn on 04/04/2021
 * @author daohn
 * @since 04/04/2021
 * @version 1.0.0
 */
public class LambdaExample {

  public static void main(String[] args) {
    var myRunnable = new MyRunnable();  // Não é mais necessário após Java 8

    /*
     * Funções possuem 4 propriedades
     *
     *  - Nome da função
     *  - Lista de parâmetros
     *  - Corpo da função
     *  - Retorno de um tipo
     */
    Thread thread = new Thread(() -> System.out.println("Thread executada"));

    thread.start();
  }

}
