package priceClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calculate3 {

    public static HashMap<String, Integer> sortBasket(String[] items) {
        HashMap<String, Integer> itemFrequencyMap = new HashMap<>();
        for (String item : items) {
            itemFrequencyMap.put(item, itemFrequencyMap.getOrDefault(item, 0) + 1);
        }
        return itemFrequencyMap;
    }

    public static BigDecimal getTotal(HashMap<String, Integer> itemFrequencyMap, HashMap<String, Price> itemPriceMap) {
        System.out.println(itemFrequencyMap);

        return itemFrequencyMap.entrySet()
                .stream()
                .reduce(new BigDecimal("0.00"), (BigDecimal subtotal, Map.Entry<String, Integer> entry) -> {
                    String item = entry.getKey();
                    Integer quantity = entry.getValue();
                    return subtotal
                            .add(itemPriceMap.get(item).totalPrice(quantity));
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
