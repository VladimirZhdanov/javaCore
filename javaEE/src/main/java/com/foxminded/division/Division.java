package com.foxminded.division;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.String.format;
import static java.lang.String.valueOf;

/**
 * The class provides method to draw the "column division".
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Division {

    /**
     * Line separator depends on your OS.
     */
    private String lineSeparator;

    /**
     * Result.
     */
    private StringBuilder drawnResult = new StringBuilder();

    /**
     * Quotient - result of division.
     */
    private StringBuilder quotient = new StringBuilder();

    /**
     * A number of dividend will be used to make column division
     * i.e. '456 / 5 = 91(with '1' as rest)', at first place '45' is reminder, '6' at second. '1' will be the rest.
     * Run the application for seeing that.
     */
    private StringBuilder reminder = new StringBuilder();

    /**
     * Constructor of the class.
     */
    public Division() {
        lineSeparator = System.lineSeparator();
        if (lineSeparator.length() == 2) {
            lineSeparator = valueOf(lineSeparator.charAt(1));
        }
    }

    /**
     * Method make division and return result in form of String.
     *
     * @param dividend - dividend - int
     * @param divisor - divisor - int
     * @return - result in form of String
     * @throws IllegalArgumentException - Can't divide on the zero.
     * @throws IllegalArgumentException - The dividend must be bigger than the divisor.
     */
    public String makeDivision(int dividend, int divisor) {
        dividend = abs(dividend);
        divisor = abs(divisor);

        if (divisor == 0) {
            throw new IllegalArgumentException("Can't divide on the zero.");
        }

        if (dividend < divisor) {
            throw new IllegalArgumentException("The dividend must be bigger than the divisor.");
        }

        String[] digits = valueOf(dividend).split("");
        int reminderNumber;
        int multiplyResult;
        int divisorDigit = calculateDigit(divisor);
        int rest;
        int tab;
        String lastReminder;
        String multiply;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = parseInt(reminder.toString());

            if (reminderNumber >= divisor) {
                rest = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;

                lastReminder = format("%" + (i + 2) + "s", "_" + reminderNumber);
                drawnResult.append(lastReminder).append(lineSeparator);

                multiply = format("%" + (i + 2) + "d", multiplyResult);
                drawnResult.append(multiply).append(lineSeparator);

                tab = lastReminder.length() - calculateDigit(multiplyResult);
                drawnResult.append(makeDivider(multiplyResult, tab)).append(lineSeparator);

                quotient.append(reminderNumber / divisor);

                reminder.replace(0, reminder.length(), valueOf(rest));
                reminderNumber = parseInt(reminder.toString());
            } else {
                if (i >= divisorDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                drawnResult.append(format("%" + (i + 2) + "s", reminderNumber)).append(lineSeparator);
            }
        }
        modifyResultToView(dividend, divisor);
        return drawnResult.toString();
    }

    /**
     * Draws line for subtracting to make new local divider.
     *
     * @param reminderNumber - int
     * @param tab - amount tabs - int
     * @return - line for subtracting
     */
    private String makeDivider(int reminderNumber, int tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }

    /**
     * Add a result column(divisor+quotient) to the drawnResult.
     *
     * @param dividend - dividend - int
     * @param divisor - divisor - int
     */
    private void modifyResultToView(int dividend, int divisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < drawnResult.length(); i++) {
            if (drawnResult.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = calculateDigit(dividend) + 1 - index[0];
        drawnResult.insert(index[2], assemblyString(tab, ' ') + "│" + quotient.toString());
        drawnResult.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-'));
        drawnResult.insert(index[0], "│" + divisor);
        drawnResult.replace(1, index[0], valueOf(dividend));
    }

    /**
     * Coefficient to draw columns.
     *
     * @param i - int
     * @return Coefficient to draw columns
     */
    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }

    /**
     * Draw lines with a given symbol.
     *
     * @param numberOfSymbols - number of symbols to draw - int
     * @param symbol - symbol - char
     * @return - line in form of String - String
     */
    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
