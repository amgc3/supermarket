package priceClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calculate3 {

    public static HashMap<String, Integer> sortBasket(String[] items) {
        HashMap<String, Integer> itemMap = new HashMap<>();
        for (String item : items) {
            itemMap.put(item, itemMap.getOrDefault(item, 0) + 1);
        }
        return itemMap;
    }

    public static BigDecimal getTotal(HashMap<String, Integer> itemMap, HashMap<String, Price> priceMap) {
        System.out.println(itemMap);

        return itemMap.entrySet()
                .stream()
                .reduce(new BigDecimal("0.00"), (BigDecimal subtotal, Map.Entry<String, Integer> entry) -> {
                    String item = entry.getKey();
                    Integer quantity = entry.getValue();
                    return subtotal
                            .add(priceMap.get(item).totalPrice(quantity));
                }, BigDecimal::add);

    }

    public static void main(String[] args) {
        // hashmap of items and prices
        HashMap<String, Price> itemPriceMap = new HashMap<>();
        itemPriceMap.put("Banana", new Price("0.20", "none"));
        itemPriceMap.put("Apple", new Price("0.35", "none"));
        itemPriceMap.put("Melon", new Price("0.50", "2for1"));
        itemPriceMap.put("Lime", new Price("0.15", "3for2"));

        String[] items = {"Banana", "Apple", "Banana", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Apple"};

        System.out.println(getTotal(sortBasket(items), itemPriceMap));

    }
}
