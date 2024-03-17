package com.shopping.cart.main.app.service;

import com.shopping.cart.main.app.exception.InvalidItemException;
import com.shopping.cart.main.app.model.ItemEnum;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ShoppingService {
  public Double calculateTotal(final List<String> shoppingList) {
    // Filter out non-shopping items
    final var itemEnumList = getItemEnumList(shoppingList);
    // Create a EnumMap as {ItemEum -> numberOfItems} from the itemEnumList
    final var itemCountMap = getItemCountMap(itemEnumList);

    double total = 0.0;
    // Iterate over the itemCountMap and calculate price for each item.
    for (Map.Entry<ItemEnum, Long> entry : itemCountMap.entrySet()) {
      total += calculateItemPrice(entry);
    }
    return total / 100;
  }

  /**
   * Method to convert item to @ItemEnum
   *
   * @param shoppingList - list of all items
   * @return - a list with valid items.
   */
  private List<ItemEnum> getItemEnumList(final List<String> shoppingList) {
    try {
      return shoppingList.stream()
        .map(String::toUpperCase)
        .map(ItemEnum::valueOf)
        .toList();
    } catch (IllegalArgumentException e) {
      throw new InvalidItemException("Invalid item found in the shopping list : " + e.getMessage());
    }
  }

  private EnumMap<ItemEnum, Long> getItemCountMap(final List<ItemEnum> filteredItemList) {
    final EnumMap<ItemEnum, Long> itemCountMap = new EnumMap<>(ItemEnum.class);
    filteredItemList
      .forEach(item -> itemCountMap.merge(item, 1L, Long::sum));
    return itemCountMap;
  }

  /**
   * Calculates the total price of the item after discount(if applicable)
   *
   * @param entry - with ItemEnum as key & count as value
   * @return total cost of items.
   */
  private Double calculateItemPrice(final Map.Entry<ItemEnum, Long> entry) {
    final ItemEnum item = entry.getKey();
    final Long numberOfItems = entry.getValue();
    long itemsCharged;
    if (item.isDiscounted()) {
      if (numberOfItems > 1) {
        itemsCharged = (numberOfItems / item.getMinItemsForOffer()) * item.getItemsPriced();
        itemsCharged += (numberOfItems % item.getMinItemsForOffer());
      } else {
        itemsCharged = numberOfItems;
      }
      return (itemsCharged * item.getPrice());
    } else {
      return (numberOfItems * item.getPrice());
    }
  }

}
