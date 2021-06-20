package com.da0hn.usecases.fluentinterfaces;

/**
 * @author daohn
 * @since 20/06/2021
 */
class FluentShopping {

  public static void main(String[] args) {
    //    order.add("Shoes");
    //    order.add("Headphones");
    //
    //    order.deliverAt("Street no 45, Jodhpur");
    //
    //    order.place();

    Order.place(order ->
                  order.add("Shoes")
                    .add("Headphones")
                    .deliverAt("Street no 45, Jodhpur")
    );

  }

}
