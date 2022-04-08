package addPromoInterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    Price price;

    @Test
    @DisplayName("Total on one item should equal item price")
    void shouldReturnItemPrice() {
        price = new Price("0.20", new FullPrice());
        assertEquals(new BigDecimal("0.20"), price.totalPrice(1), "Total should equal item price");
    }

    @Test
    @DisplayName("When promotion is FullPrice, total  should equal quantity multiplied by price")
    void shouldReturnQuantityTimesPrice() {
        price = new Price("0.20", new FullPrice());
        assertEquals(new BigDecimal("1.60"), price.totalPrice(8), "Total should equal item price times quantity" );
    }

    @Test
    @DisplayName("When quantity is less than minimum promotion quantity, it should not include discount")
    void shouldNotIncludeDiscount() {
        price = new Price("0.15", new ThreeForTwo());
        assertEquals(new BigDecimal("0.30"), price.totalPrice(2));
    }

    @Test
    @DisplayName("When TwoForOne and quantity is even, it should charge only for half")
    void shouldChargeForHalf() {
        price = new Price("0.50", new TwoForOne());
        assertEquals(new BigDecimal("2.50"), price.totalPrice(10));
    }

    @Test
    @DisplayName("When TwoForOne and quantity is odd, it should charge one item full price")
    void shouldChargeOneItemFullPrice() {
        price = new Price("0.50", new TwoForOne());
        assertEquals(new BigDecimal("3.00"), price.totalPrice(11));
    }

    @Test
    @DisplayName("When ThreeForTwo and quantity is a multiple of 3, it should charge only two thirds")
    void shouldChargeTwoThirds() {
        price = new Price("0.15", new ThreeForTwo());
        assertEquals(new BigDecimal("0.60"), price.totalPrice(6));
    }

    @Test
    @DisplayName("When ThreeForTwo and quantity is not a multiple of 3, it should charge one or two items full price")
    void shouldChargeSomeFullPrice() {
        price = new Price("0.15", new ThreeForTwo());
        assertEquals(new BigDecimal("0.75"), price.totalPrice(7));
        assertEquals(new BigDecimal("0.60"), price.totalPrice(5));

    }




}