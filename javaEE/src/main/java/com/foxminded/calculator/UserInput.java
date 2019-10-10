package com.foxminded.calculator;

import java.util.Scanner;

/**
 * UserInput
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class UserInput implements Input {
    private Scanner input = new Scanner(System.in);

    /**
     * Method get input values from an user.
     *
     * @return - a input value - String
     */
    @Override
    public String ask() {
        return input.nextLine();
    }
}
