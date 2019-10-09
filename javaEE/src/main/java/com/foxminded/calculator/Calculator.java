package com.foxminded.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Calculator {
    private Double result;
    //private final Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)?\\s*(\\S)\\s*(-?\\d+\\.?\\d*)", Pattern.CASE_INSENSITIVE);
    private final Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)?/(-?\\d+\\.?\\d*)", Pattern.CASE_INSENSITIVE);
    private Actions actions;
    private Map<String, BiConsumer> operations;

    public Double getResult() {
        return result;
    }

    private void loudOperations() {
        operations.put("/", div());
    }

    private BiConsumer<Double, Double> div() {
        return actions::division;
    }

    /**
     * Constructor of the class.
     */
    public Calculator() {
        actions = new Actions();
        operations = new HashMap<>();
        loudOperations();
    }

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
                operations.get(operator).accept(firstValue, secondValue);
                result = actions.getResult();
                //System.out.println(firstValue + operator + secondValue + " = " + result);
            }
            if (indexStart == 0 && result != null) {
                var getValue = input.substring(indexEnd).trim();
                double value = Double.parseDouble(getValue);
                Double temp = result;
                operations.get(operator).accept(result, value);
                result = actions.getResult();
                //System.out.println(temp + operator + value + " = " + result);
            }
        }
        return checker;
    }

    private boolean checkInput(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
