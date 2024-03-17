package com.shopping.cart.main.app.service;

import com.shopping.cart.main.app.exception.InvalidItemException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShoppingServiceTest {

  private final ShoppingService shoppingService = new ShoppingService();

  @Test
  public void calculateTotal() {
    final var itemList = List.of("Apple", "Banana","Melon","Lemon");
    final Double expectedPrice = 1.2;
    final var actualTotalPrice = shoppingService.calculateTotal(itemList);
    assertEquals(expectedPrice, actualTotalPrice);
  }

  @Test
  public void givenInvalidItemName_thenThrowsException() {
    final var itemList = List.of("Tomota", "Banana","Melon","Lemon");

    assertThrows(InvalidItemException.class, ()-> shoppingService.calculateTotal(itemList));
  }

  @Test
  public void calculateTotalForMultipleItemsWithDiscount() {
    final var itemList = List.of("Apple", "Banana","Melon","Melon", "Melon","Lemon", "Lemon");
    final Double expectedPrice = 1.85;
    final var actualTotalPrice = shoppingService.calculateTotal(itemList);
    assertEquals(expectedPrice, actualTotalPrice);
  }

  @Test
  public void calculateTotalForMultipleItemsWithDiscountApplied() {
    final var itemList = List.of("Apple", "Banana","Melon","Melon","Lemon", "Lemon", "Lemon");
    final Double expectedPrice = 1.35;
    final var actualTotalPrice = shoppingService.calculateTotal(itemList);
    assertEquals(expectedPrice, actualTotalPrice);
  }

  @Test
  public void calculateTotalForMultipleItemsForDiscountAndNoDiscount() {
    final var itemList = List.of("Apple", "Banana","Melon","Melon","Melon","Lemon", "Lemon", "Lemon", "Lemon");
    final Double expectedPrice = 2.0;
    final var actualTotalPrice = shoppingService.calculateTotal(itemList);
    assertEquals(expectedPrice, actualTotalPrice);
  }

  @Test
  public void calculateTotalForMultipleItemsForDiscountAndNoDiscountItems() {
    final var itemList = List.of("Apple", "Banana","Melon","Melon","Melon","Melon","Lemon", "Lemon", "Lemon", "Lemon","Lemon","Lemon");
    final Double expectedPrice = 2.15;
    final var actualTotalPrice = shoppingService.calculateTotal(itemList);
    assertEquals(expectedPrice, actualTotalPrice);
  }



}
