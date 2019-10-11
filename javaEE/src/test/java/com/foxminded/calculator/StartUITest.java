package com.foxminded.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StartUITest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream newOut = new PrintStream(out);

        @Override
        public void accept(String s) {
            newOut.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };
    private Calculator calculator = new Calculator();

    @Test
    public void shouldReturnResultOfCalculationsWhenUserDoesCalculations() {
        Input input = new SimulateInput(Arrays.asList("1/2", "-2", "*10", "+3", "exit"));
        new StartUI(input, calculator, output).run();
        double expected = -12;
        double actual = calculator.getResult();
        assertEquals(expected, actual,
                "Should return result of calculations when User Does calculations...");
    }
}