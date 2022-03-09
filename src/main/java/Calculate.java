import java.math.BigDecimal;
import java.util.HashMap;

public class Calculate {

    public static HashMap<String, Integer> sortBasket(String[] items) {
        HashMap<String, Integer> itemMap = new HashMap<>();
        for (String item : items) {
            if (itemMap.containsKey(item)) {
                itemMap.put(item, itemMap.get(item) + 1);
            } else {
                itemMap.put(item, 1);
            }
        }
        return itemMap;
    }

    public static BigDecimal getTotal(HashMap<String, Integer> itemMap, HashMap<String, BigDecimal> priceMap) {
        BigDecimal total = new BigDecimal("0.00");
        for (String item : itemMap.keySet()) {
            // Melons are 50p each, but are available as ‘buy one get one free’
            if (item == "Melon" && itemMap.get(item) >= 2) {
                total = total.add(new BigDecimal(Integer.toString((itemMap.get(item) / 2) + (itemMap.get(item) % 2))).multiply(priceMap.get(item)));
            // Limes are 15p each, but are available in a ‘three for the price of two’ offer
            } else if (item == "Lime" && itemMap.get(item) >= 3) {
                total = total.add(new BigDecimal(Integer.toString((itemMap.get(item) / 3) * 2 + (itemMap.get(item) % 3))).multiply(priceMap.get(item)));

            } else {
                total = total.add(new BigDecimal(Integer.toString(itemMap.get(item))).multiply(priceMap.get(item)));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        // hashmap of items and prices
        HashMap<String, BigDecimal> itemPriceMap = new HashMap<>();
        itemPriceMap.put("Banana", new BigDecimal(Double.toString(0.20)));
        itemPriceMap.put("Apple", new BigDecimal(Double.toString(0.35)));
        itemPriceMap.put("Melon", new BigDecimal(Double.toString(0.50)));
        itemPriceMap.put("Lime", new BigDecimal(Double.toString(0.15)));

        String[] items = { "Banana", "Apple", "Banana", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Apple" };

        System.out.println(getTotal(sortBasket(items), itemPriceMap));

    }
}
