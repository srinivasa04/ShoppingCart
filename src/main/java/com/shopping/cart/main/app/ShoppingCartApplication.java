package com.shopping.cart.main.app;


import com.shopping.cart.main.app.service.ShoppingService;

import java.util.stream.Stream;

/**
 * Shopping cart application to find the total price for shopping items.
 */
public class ShoppingCartApplication {

  private static final ShoppingService shoppingService = new ShoppingService();
  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Item list is expected in command line args");
      System.exit(-1);
    }

    final var shoppingList = Stream.of(args[0].split(","))
      .map(String::trim)
      .toList();

    final var totalAmount = shoppingService.calculateTotal(shoppingList);
    System.out.printf("Total amount(£) : %.2f%n  ", totalAmount);
  }

}
