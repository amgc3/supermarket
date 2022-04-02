import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("Add two numbers")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    @DisplayName("Multiply two numbers")
    void multiply() {
        assertAll(() -> assertEquals(4, Calculator.multiply(2, 2)),
                () -> assertEquals(-4, Calculator.multiply(2, -2)),
                () -> assertEquals(4, Calculator.multiply(-2, -2)),
                () -> assertEquals(0, Calculator.multiply(1, 0)));
    }

    @Test
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        assertAll(
                () -> assertEquals(0, Calculator.multiply(0, 5), "Multiple with zero should be zero"),
                () -> assertEquals(0, Calculator.multiply(5, 0), "Multiple with zero should be zero")
        );
    }


}