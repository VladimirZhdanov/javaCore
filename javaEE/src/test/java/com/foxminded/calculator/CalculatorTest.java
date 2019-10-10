package com.foxminded.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CalculatorTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class CalculatorTest {
    public Calculator calculator = new Calculator();

    @Test
    void shouldReturnResultOfSetMethod() {
        calculator.setResult(666.666);
        double expected = 666.666;
        double actual = calculator.getResult();
        assertEquals(expected, actual,
                "Should return result of the set method...");
    }

    @Test
    void shouldReturnResultOfCalculationWhenGiveCorrectInput() {
        calculator.calculate("2/4");
        double expected = 0.5;
        double actual = calculator.getResult();
        assertEquals(expected, actual,
                "Should return result of the calculation 2/4 = 0.5...");
    }

    @Test
    void shouldReturnResultOfCalculationWhenGiveCorrectInput2() {
        calculator.calculate("2/4");
        calculator.calculate("/10");
        double expected = 0.05;
        double actual = calculator.getResult();
        assertEquals(expected, actual,
                "Should return result of the calculation 2/4 = 0.5/10 = 0.05...");
    }

    @Test
    void shouldReturnFalseWhenInputIncorrect() {
        boolean expected = false;
        boolean actual = calculator.calculate("1div4");
        assertEquals(expected, actual,
                "Should return false to incorrect input...");
    }

    @Test
    void shouldReturnFalseWhenInputIsNull() {
        boolean expected = false;
        boolean actual = calculator.calculate(null);
        assertEquals(expected, actual,
                "Should return false for null input...");
    }
}
