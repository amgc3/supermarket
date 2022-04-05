import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static priceClass.Calculate3.sortBasket;

public class CalculateTest {

    @Test
    @DisplayName("returns frequency table correct size")
    void testSortBasketSize() {
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
    @DisplayName("return frequency table")
    void testSortBasket() {
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
    @DisplayName("calculate total")
    void getTotal() {
    }
}