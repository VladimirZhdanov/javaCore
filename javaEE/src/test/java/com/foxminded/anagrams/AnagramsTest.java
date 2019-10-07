package com.foxminded.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class AnagramsTest {
    public Anagrams anagrams;
    public static final String ONLY_LETTERS = "abcd efgh";
    public static final String REVERSED_LETTERS = "dcba hgfe";
    public static final String ONLY_NUMBERS = "32432 324234";
    public static final String ONLY_SYMBOLS = "№@#$%^&*()/\"|\\;:";
    public static final String LETTERS_AND_SYMBOLS = "abcd №@#$%^&*()/\"|\\;:";
    public static final String REVERSED_LETTERS_AND_SYMBOLS = "dcba №@#$%^&*()/\"|\\;:";
    public static final String LETTERS_AND_NUMBERS = "abcd 324234";
    public static final String REVERSED_LETTERS_AND_NUMBERS = "dcba 324234";
    public static final String LETTERS_NUMBERS_SYMBOLS = " c1onstHomeSPB@gmail.com";
    public static final String REVERSED_LETTERS_NUMBERS_SYMBOLS = " m1ocliamgBPSe@moHts.noc";
    public static final String WHITESPACE = " ";

    @BeforeEach
    public void initEach() {
        anagrams = new Anagrams();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGiveNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                anagrams.reverseString(null));
        assertEquals("Something went wrong...", exception.getMessage());
    }

    @Test
    public void shouldDoNothingWhenApplyNumbersToTheMethod() {
        String actual = anagrams.reverseString(ONLY_NUMBERS);
        assertEquals(ONLY_NUMBERS, actual,
                "Reverse method should return the non-reversed numbers");
    }

    @Test
    public void shouldDoNothingWhenApplySymbolsToTheMethod() {
        String actual = anagrams.reverseString(ONLY_SYMBOLS);
        assertEquals(ONLY_SYMBOLS, actual,
                "Reverse method should return the non-reversed symbols");
    }

    @Test
    public void shouldReverseStringWhenApplyLettersToTheMethod() {
        String actual = anagrams.reverseString(ONLY_LETTERS);
        assertEquals(REVERSED_LETTERS, actual,
                "Reverse method should return the reversed letters");
    }

    @Test
    public void shouldReverseLettersWhenApplyStringToTheMethod1() {
        String actual = anagrams.reverseString(LETTERS_AND_NUMBERS);
        assertEquals(REVERSED_LETTERS_AND_NUMBERS, actual,
                "Reverse method should return the reversed letters only!");
    }

    @Test
    public void shouldReverseLettersWhenApplyStringToTheMethod2() {
        String actual = anagrams.reverseString(LETTERS_AND_SYMBOLS);
        assertEquals(REVERSED_LETTERS_AND_SYMBOLS, actual,
                "Reverse method should return the reversed letters only!");
    }

    @Test
    public void shouldReverseLettersWhenApplyStringToTheMethod3() {
        String actual = anagrams.reverseString(LETTERS_NUMBERS_SYMBOLS);
        assertEquals(REVERSED_LETTERS_NUMBERS_SYMBOLS, actual,
                "Reverse method should return the reversed letters only!");
    }

    @Test
    public void shouldDeleteWhiteSpaceWhenApplyWhiteSpaceToTheMethod() {
        String actual = anagrams.reverseString(WHITESPACE);
        assertEquals("", actual,
                "Reverse method should return empty string!");
    }
}