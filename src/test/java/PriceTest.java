import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import priceClass.Price;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriceTest {
    Price price;

    @Test
    @DisplayName("Total of one item should equal item price")
    void testTotalPriceForOne() {
        price = new Price("0.20", "none");
        assertEquals(new BigDecimal("0.20"), price.totalPrice(1),
                "Total of one item should return item price");
    }

    @Test
    @DisplayName("Total without promotion should equal quantity multiplied by price")
    void testTotalPriceWithoutPromotion() {
        price = new Price("0.20", "none");
        assertEquals(new BigDecimal("1.60"), price.totalPrice(8),
                "Total should return item price multiplied by quantity");
    }

    @Test
    @DisplayName("Total with promotion for one item")
    void testTotalPriceWithPromotion() {
        price = new Price("0.50", "2for1");
        assertEquals(new BigDecimal("0.50"), price.totalPrice(1),
                "Total of one item should return item price");
    }

    @Test
    @DisplayName("Total 2for1 even case")
    void testTotalPrice2for1even() {
        price = new Price("0.50", "2for1");
        assertEquals(new BigDecimal("1.00"), price.totalPrice(4),
                "2for1, price 0.50, quantity 4, should return 1.00");
    }

    @Test
    @DisplayName("Total 2for1 odd case")
    void testTotalPrice2for1odd() {
        price = new Price("0.50", "2for1");
        assertEquals(new BigDecimal("1.50"), price.totalPrice(5),
                "2for1, price 0.50, quantity 5, should return 1.50");
    }

    @Test
    @DisplayName("Total 3for2 when quantity is a multiple of 3")
    void testTotalPrice3for2() {
        price = new Price("0.15", "3for2");
        assertEquals(new BigDecimal("0.60"), price.totalPrice(6),
                "3for2, price 0.15, quantity 6 should return 0.60");
    }

    @Test
    @DisplayName("Total 3for2 when quantity is not a multiple of 3")
    void testTotalPrice3for2five() {
        price = new Price("0.15", "3for2");
        assertEquals(new BigDecimal("0.60"), price.totalPrice(5),
                "3for2, price 0.15, quantity 5 should return 0.60");
    }


    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

}
