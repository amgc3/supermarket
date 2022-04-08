package addPromoInterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static priceClass.Calculate3.sortBasket;

class Calculate4Test {

    @Test
    @DisplayName("Should return the number of elements of frequency table")
    void shouldReturnTheCorrectFrequencyTableSize() {

        String[] items = {"Banana", "Apple", "Banana", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Apple"};

        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("lime", 1);
        map.put("Apple", 3);
        map.put("Melon", 3);

        Map<String, Integer> actual = sortBasket(items);

        assertEquals(map.size(), actual.size());
    }

    @Test
    @DisplayName("Should return a frequency table")
    void shouldReturnFrequencyTable() {

        String[] items = {"Banana", "Apple", "Banana", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Apple"};

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Banana", 3);
        expected.put("Lime", 1);
        expected.put("Apple", 3);
        expected.put("Melon", 3);

        Map<String, Integer> actual = sortBasket(items);

        assertTrue(expected.equals(actual));
    }

    @Test
    @DisplayName("Should return the basket total")
    void getTotal() {

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put("Banana", 3);
        frequencyMap.put("Lime", 5);
        frequencyMap.put("Apple", 3);
        frequencyMap.put("Melon", 3);

        HashMap<String, Price> itemPriceMap = new HashMap<>();
        itemPriceMap.put("Banana", new Price("0.20", new FullPrice()));
        itemPriceMap.put("Apple", new Price("0.35", new FullPrice()));
        itemPriceMap.put("Melon", new Price("0.50", new TwoForOne()));
        itemPriceMap.put("Lime", new Price("0.15", new ThreeForTwo()));

        assertEquals(new BigDecimal("3.25"), Calculate4.getTotal(frequencyMap, itemPriceMap) );


    }
}