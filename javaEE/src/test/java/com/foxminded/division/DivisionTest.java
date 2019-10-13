package com.foxminded.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class DivisionTest {
    public Division division = new Division();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGiveZeroDivisor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                division.makeDivision(1, 0));
        assertEquals("Can't divide on the zero.", exception.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGiveDividendBiggerThanDivisor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                division.makeDivision(1, 2));
        assertEquals("The dividend must be bigger than the divisor.", exception.getMessage());
    }

    @Test
    public void shouldReturnCorrectedColumnOfDivisionWhenGiveCorrectedParameters1() {
        String expected = "_78945│4\n" +
                " 4    │-----\n" +
                " -    │19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";
        String actual = division.makeDivision(78945, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectedColumnOfDivisionWhenGiveCorrectedParameters2() {
        String expected = "_456│11\n" +
                " 44 │--\n" +
                " -- │41\n" +
                " _16\n" +
                "  11\n" +
                "  --\n" +
                "   5\n";
        String actual = division.makeDivision(456, 11);
        assertEquals(expected, actual);
    }
}