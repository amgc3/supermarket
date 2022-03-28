import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculateWithLambda {

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

        return itemMap.entrySet()
                .stream()
                .reduce(new BigDecimal("0.00"), (BigDecimal subtotal, Map.Entry<String, Integer> entry) -> {
                    String item = entry.getKey();
                    Integer quantity = entry.getValue();
                    // Melons are 50p each, but are available as ‘buy one get one free’
                    if (item == "Melon" && quantity >= 2) {
                        return subtotal
                                .add(new BigDecimal(Integer.toString((quantity / 2) + (quantity % 2)))
                                        .multiply(priceMap.get(item)));
                         //Limes are 15p each, but are available in a ‘three for the price of two’ offer
                    } else if (item == "Lime" && quantity >= 3) {
                        return subtotal
                                .add(
                                new BigDecimal(Integer.toString((quantity / 3) * 2 + (quantity % 3)))
                                        .multiply(priceMap.get(item)));

                    } else {
                        return subtotal
                                .add(new BigDecimal(Integer.toString(quantity)).multiply(priceMap.get(item)));
                    }
                }, (valueSoFar , newValue) -> valueSoFar.add(newValue));

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
