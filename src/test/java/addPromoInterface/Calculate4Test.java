package addPromoInterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void getTotal() {
    }
}