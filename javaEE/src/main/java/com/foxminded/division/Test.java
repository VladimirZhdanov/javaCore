package com.foxminded.division;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Test {
    private StringBuilder result;

    public StringBuilder getResult() {
        return result;
    }

    public void draw(int first, int second) {
        System.out.println(String.format("_%d|%d", first, second));
    }

    public void calculate(int first, int second) {
        draw(first, second);
        int boxBlue = 0;
        String boxRed = "";
        int boxResult = 0;
        int digit;
        int divResult = first / second;
        String[] digits = valueOf(first).split("");
        for (int i = 0; i < digits.length; i++) {
            digit = parseInt(boxRed + digits[i]);
            while (digit < second) {
                digit = parseInt(digit + digits[i+1]);
                i++;
            }
            if (digit >= second) {
                boxResult = digit / second;
                boxBlue = boxResult * second;
                boxRed = valueOf(digit - boxBlue);
            }
            System.out.println(digit + " " + boxBlue + " " + boxRed + " " + boxResult + " " + divResult);
        }
    }

    public static void main(String[] argc) {
        Test test = new Test();
        test.calculate(78945, 4);
    }
}
