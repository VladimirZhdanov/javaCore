package com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class AnagramsTest {
    private Anagrams anagrams;
    private static final String ONLY_LETTERS = "abcd efgh";
    private static final String REVERSED_LETTERS = "dcba hgfe";
    private static final String ONLY_NUMBERS = "32432 324234";
    private static final String ONLY_SYMBOLS = "№@#$%^&*()/\"|\\;:";
    private static final String LETTERS_AND_SYMBOLS = "abcd №@#$%^&*()/\"|\\;:";
    private static final String REVERSED_LETTERS_AND_SYMBOLS = "dcba №@#$%^&*()/\"|\\;:";
    private static final String LETTERS_AND_NUMBERS = "abcd 324234";
    private static final String REVERSED_LETTERS_AND_NUMBERS = "dcba 324234";
    private static final String LETTERS_NUMBERS_SYMBOLS = " c1onstHomeSPB@gmail.com";
    private static final String REVERSED_LETTERS_NUMBERS_SYMBOLS = " m1ocliamgBPSe@moHts.noc";
    private static final String WHITESPACE = " ";

    @BeforeEach
    void initEach() {
        anagrams = new Anagrams();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenGiveNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                anagrams.reverseString(null));
        assertEquals("Something went wrong...", exception.getMessage());
    }

    @Test
    void shouldDoNothingWhenApplyNumbersToTheMethod() {
        assertEquals(ONLY_NUMBERS, anagrams.reverseString(ONLY_NUMBERS),
                "Reverse method should return the non-reversed numbers");
    }

    @Test
    void shouldDoNothingWhenApplySymbolsToTheMethod() {
        assertEquals(ONLY_SYMBOLS, anagrams.reverseString(ONLY_SYMBOLS),
                "Reverse method should return the non-reversed symbols");
    }

    @Test
    void shouldReverseStringWhenApplyLettersToTheMethod() {
        assertEquals(REVERSED_LETTERS, anagrams.reverseString(ONLY_LETTERS),
                "Reverse method should return the reversed letters");
    }

    @Test
    void shouldReverseLettersWhenApplyStringToTheMethod1() {
        assertEquals(REVERSED_LETTERS_AND_NUMBERS, anagrams.reverseString(LETTERS_AND_NUMBERS),
                "Reverse method should return the reversed letters only!");
    }

    @Test
    void shouldReverseLettersWhenApplyStringToTheMethod2() {
        assertEquals(REVERSED_LETTERS_AND_SYMBOLS, anagrams.reverseString(LETTERS_AND_SYMBOLS),
                "Reverse method should return the reversed letters only!");
    }

    @Test
    void shouldReverseLettersWhenApplyStringToTheMethod3() {
        assertEquals(REVERSED_LETTERS_NUMBERS_SYMBOLS, anagrams.reverseString(LETTERS_NUMBERS_SYMBOLS),
                "Reverse method should return the reversed letters only!");
    }

    @Test
    void shouldDeleteWhiteSpaceWhenApplyWhiteSpaceToTheMethod() {
        assertEquals("", anagrams.reverseString(WHITESPACE),
                "Reverse method should return empty string!");
    }
}