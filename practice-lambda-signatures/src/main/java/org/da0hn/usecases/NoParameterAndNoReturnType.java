package org.da0hn.usecases;

import org.da0hn.lambda.Name;

/**
 * Created by daohn on 14/06/2021
 * @author daohn
 * @since 14/06/2021
 */
public class NoParameterAndNoReturnType {

  public static void main(String[] args) {
    Name name = () -> System.out.println("John");
    name.myName();

  }

}
