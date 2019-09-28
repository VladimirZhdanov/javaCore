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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGiveNull() {
        anagrams.reverseString(null);
    }


    @Test
    public void shouldReverseStringWhenApplyTheMethod1() {
        String input = " a1bcd efg!h";
        String expected = " d1cba hgf!e";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod2() {
        String input = "abcd efgh";
        String expected = "dcba hgfe";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod3() {
        String input = "hool1";
        String expected = "looh1";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod4() {
        String input = "2452";
        String expected = "2452";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod5() {
        String input = "abcd 2452";
        String expected = "dcba 2452";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod6() {
        String input = "constHomeSPB@gmail.com";
        String expected = "mocliamgBPSe@moHts.noc";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReverseStringWhenApplyTheMethod7() {
        String input = " ";
        String expected = "";
        String result = anagrams.reverseString(input);
        assertThat(result, is(expected));
    }
}