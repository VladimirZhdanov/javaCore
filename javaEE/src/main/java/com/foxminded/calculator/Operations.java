package com.foxminded.calculator;

/**
 * Operations for calculator application.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */

public class Operations {
    private double result = 0;

    /**
     * Divides numbers.
     * @param first - 1st value - double
     * @param second - Second value - double
     * @throws IllegalArgumentException throws IAE when divide on the zero
     */
    public void division(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Can't divide on the zero");
        }
        result = first / second;
    }

    /**
     * Multiply numbers.
     * @param fist - 1st value - double
     * @param second - Second value - double
     */
    public void multiply(double fist, double second) {
        this.result = fist * second;
    }

    /**
     * To sum numbers.
     * @param fist - 1st value - double
     * @param second - Second value - double
     */
    public void add(double fist, double second) {
        this.result = fist + second;
    }

    /**
     * Subtract numbers.
     * @param fist - 1st value - double
     * @param second - Second value - double
     */
    public void subtract(double fist, double second) {
        this.result = fist - second;
    }

    /**
     * Get result of operations.
     * @return - result of operations
     */
    public double getResult() {
        return result;
    }
}
