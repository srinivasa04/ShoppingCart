package com.shopping.cart.main.app.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Master list of items with details.
 * Valid Shopping Item with price & discount details.
 */
public enum ItemEnum {
  APPLE(35.0, false, 0, 0),
  BANANA(20.0, false, 0, 0),
  MELON(50.0, true, 2, 1),
  LEMON(15.0, true, 3, 2);

  private final Double price;
  private final boolean discounted;
  private final int minItemsForOffer;
  private final int itemsPriced;

  ItemEnum(Double price, boolean discounted, int i1, int i2) {
    this.price = price;
    this.discounted = discounted;
    this.minItemsForOffer = i1;
    this.itemsPriced = i2;
  }

  private static final Map<String, ItemEnum> itemEnumMap =
    Arrays.stream(values())
      .collect(Collectors.toMap(Enum::name, Function.identity()));

   public Double getPrice() {
    return price;
  }

  public boolean isDiscounted() {
    return discounted;
  }

  public int getMinItemsForOffer() {
    return minItemsForOffer;
  }

  public int getItemsPriced() {
    return itemsPriced;
  }
}
