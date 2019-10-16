package com.foxminded.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OperationsTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class OperationsTest {
    Operations operations = new Operations();

    @Test
    void shouldReturnResultOfCalculationWhenGiveCorrectInput() {
        operations.division(2, 4);
        double expected = 0.5;
        double actual = operations.getResult();
        assertEquals(expected, actual,
                "Should return result of the calculation 2/4 = 0.5...");
    }

    @Test
    void shouldReturnResultOfCalculationWhenGiveCorrectInput2() {
        operations.division(2, -4);
        double expected = -0.5;
        double actual = operations.getResult();
        assertEquals(expected, actual,
                "Should return result of the calculation 2/-4 = -0.5...");
    }
}