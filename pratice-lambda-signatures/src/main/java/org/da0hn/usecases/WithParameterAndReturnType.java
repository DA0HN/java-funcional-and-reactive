package org.da0hn.usecases;

import org.da0hn.lambda.LengthOfString;

/**
 * Created by daohn on 14/06/2021
 * @author daohn
 * @since 14/06/2021
 */
public class WithParameterAndReturnType {

  public static void main(String[] args) {

    LengthOfString len = (str) -> str.length();

    var length = len.length("Da0hn");

    System.out.println(length);

  }

}
