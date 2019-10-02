package com.foxminded.anagrams;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class AnagramsTest {
    private Anagrams anagrams = new Anagrams();
    private static final String ONLY_LETTERS = "abcd efgh";
    private static final String ONLY_NUMBERS = "32432 324234";
    private static final String REVERSED_LETTERS = "dcba hgfe";
    private static final String LETTERS_AND_NUMBERS = " c1onstHomeSPB@gmail.com";
    private static final String REVERSED_LETTERS_AND_NUMBERS = " m1ocliamgBPSe@moHts.noc";
    private static final String WHITESPACE = " ";

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGiveNull() {
        anagrams.reverseString(null);
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod1() {
        String result = anagrams.reverseString(ONLY_NUMBERS);
        assertThat(result, is(ONLY_NUMBERS));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod2() {
        String result = anagrams.reverseString(ONLY_LETTERS);
        assertThat(result, is(REVERSED_LETTERS));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod3() {
        String result = anagrams.reverseString(LETTERS_AND_NUMBERS);
        assertThat(result, is(REVERSED_LETTERS_AND_NUMBERS));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod4() {
        String result = anagrams.reverseString(WHITESPACE);
        assertThat(result, is(""));
    }
}