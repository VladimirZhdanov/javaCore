package com.foxminded.calculator;

import java.util.List;

/**
 * SimulateInput
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class SimulateInput implements Input {
    private final List<String> listOfSimulateInput;
    private int count = 0;

    public SimulateInput(final List<String> values) {
        this.listOfSimulateInput = values;
    }

    @Override
    public String ask() {
        String result = "";
        if (count < listOfSimulateInput.size()) {
            result = listOfSimulateInput.get(count++);
        }
        return result;
    }
}
