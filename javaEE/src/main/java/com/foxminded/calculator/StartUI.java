package com.foxminded.calculator;

import java.util.function.Consumer;

/**
 * StartUI
 * UI class of the calculator.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class StartUI {
    private Input input;
    private Consumer<String> output;
    private Calculator calculator;

    /**
     * Constructor of the class.
     *
     * @param input - the input argument
     * @param calculator - instance of calculator class
     * @param output - the output argument
     */
    public StartUI(Input input, Calculator calculator, Consumer<String> output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    /**
     * Method to run the application.
     */
    public void run() {
        System.out.println("Hello! This is simple calculator! Enjoy ;) Type \"Exit\" in order to exit.");
        String userMassage = this.input.ask();
        while (!"Exit".equalsIgnoreCase(userMassage)) {
            boolean checker = calculator.calculate(userMassage);
            if (!checker) {
                output.accept("error");
            } else {
                output.accept(String.valueOf(calculator.getResult()));
            }
            userMassage = this.input.ask();
        }
        output.accept("Exit.");
    }

    /**
     * Main method to run the application.
     *
     * @param args - args - String[]
     */
    public static void main(String[] args) {
        new StartUI(new UserInput(), new Calculator(), System.out::println).run();
    }
}
