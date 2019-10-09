package com.foxminded.calculator;

import java.util.function.Consumer;

/**
 * StartUI
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class StartUI {
    private Input input;
    private Consumer<String> output;
    private Calculator calculator;

    public StartUI(Input input, Calculator calculator, Consumer<String> output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    public void run() {
        System.out.println("Hello! This is simple calculator! Enjoy ;) Type \"Exit\" in order to exit.");
        String userMassage = this.input.ask();
        while (!"Exit".equalsIgnoreCase(userMassage)) {
            boolean checker = calculator.calculate(userMassage);
            if (!checker) {
                output.accept("error");
            } else output.accept(String.valueOf(calculator.getResult()));
            userMassage = this.input.ask();
        }
        output.accept("Exit.");
    }

    public static void main(String[] args) {
        new StartUI(new UserInput(), new Calculator(), System.out::println).run();
    }
}
