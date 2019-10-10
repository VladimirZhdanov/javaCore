package com.foxminded.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator
 * Class to calculations.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Calculator {
    private double result;
    private final Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)?/(-?\\d+\\.?\\d*)", Pattern.CASE_INSENSITIVE);
    private Operations operations;
    private Map<String, BiConsumer> actions;
    /**
     * Get result.
     *
     * @return - return the result(double)
     */
    public double getResult() {
        return result;
    }

    /**
     * Set the result.
     *
     * @param result - double
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Loud operation to the HashMap.
     */
    private void loudOperations() {
        actions.put("/", div());
    }

    /**
     * Method to do division.
     * @return - method to do division
     */
    private BiConsumer<Double, Double> div() {
        return operations::division;
    }

    /**
     * Constructor of the class.
     */
    public Calculator() {
        operations = new Operations();
        actions = new HashMap<>();
        loudOperations();
    }

    /**
     * For executing calculations.
     * @param input - input string
     * @return - check if the input value passed the validation method.
     */
    public boolean calculate(String input) {
        boolean checker = checkInput(input);
        if (checker) {
            Pattern operationPattern = Pattern.compile("/");
            Matcher matcher = operationPattern.matcher(input);
            matcher.find();

            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            String operator = input.substring(indexStart, indexStart + 1).trim();

            if (indexStart != 0) {
                var getValue = input.substring(0, indexStart).trim();
                double firstValue = Double.parseDouble(getValue);
                getValue = input.substring(indexEnd).trim();
                double secondValue = Double.parseDouble(getValue);
                actions.get(operator).accept(firstValue, secondValue);
                result = operations.getResult();
            }
            if (indexStart == 0) {
                var getValue = input.substring(indexEnd).trim();
                double value = Double.parseDouble(getValue);
                actions.get(operator).accept(result, value);
                result = operations.getResult();
            }
        }
        return checker;
    }

    /**
     * Validation method.
     *
     * @param input - input value from an user(String)
     * @return - check if the input value passed the validation method.
     */
    private boolean checkInput(String input) {
        boolean result = false;
        if (input != null) {
            Matcher matcher = pattern.matcher(input);
            result = matcher.find();
        }
        return result;
    }
}
