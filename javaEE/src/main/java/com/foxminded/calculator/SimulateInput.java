package com.foxminded.calculator;

import java.util.List;

/**
 * SimulateInput
 * Class needs for imitating input from an user.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class SimulateInput implements Input {
    private final List<String> listOfSimulateInput;
    private int count = 0;

    /**
     * Constructor of the class.
     *
     * @param values - list of input from an "user"
     */
    public SimulateInput(final List<String> values) {
        this.listOfSimulateInput = values;
    }

    /**
     * Method get input values from the list. (imitate actions from an user)
     *
     * @return - a input value - String
     */
    @Override
    public String ask() {
        String result = "";
        if (count < listOfSimulateInput.size()) {
            result = listOfSimulateInput.get(count++);
        }
        return result;
    }
}
