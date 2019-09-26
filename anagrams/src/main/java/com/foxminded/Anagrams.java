package com.foxminded;

import java.util.StringJoiner;

import static java.lang.Character.isAlphabetic;

/**
 * Anagrams
 * An application that provides method to reverse alphabetic symbols in given string.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Anagrams {

    private static final String WHITESPACE = " ";

    /**
     * Reverse each alphabetic symbol in given array of char, non-alphabetic will be skipped.
     *
     * @param word - a word with letters that need to be reversed.
     */
    private void reverseWord(char[] word) {
        int rightPointer = word.length - 1;
        int leftPointer = 0;

        while (leftPointer < rightPointer) {
            if (!isAlphabetic(word[leftPointer])) {
                leftPointer++;
            } else if (!isAlphabetic(word[rightPointer])) {
                rightPointer--;
            } else {
                swapLetters(rightPointer, leftPointer, word);
                leftPointer++;
                rightPointer--;
            }
        }
    }

    /**
     * Swap letters on the specified positions: "rightPointer" and "leftPointer".
     *
     * @param rightPointer - right pointer.
     * @param leftPointer - left pointer.
     * @param word - a word for swap letters.
     */
    private void swapLetters(int rightPointer, int leftPointer, char[] word) {
        char temp = word[leftPointer];
        word[leftPointer] = word[rightPointer];
        word[rightPointer] = temp;
    }

    /**
     * Reverse each alphabetic symbol in given string, word by word,
     * non-alphabetic will be skipped.
     *
     * @param string string that you want to reverse
     * @return revered string
     */
    public String reverseString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Something went wrong...");
        }
        StringJoiner joiner = new StringJoiner(WHITESPACE);
        String[] stringArray = string.split(WHITESPACE);
        for (int i = 0; i < stringArray.length; i++) {
            char[] word = stringArray[i].toCharArray();
            reverseWord(word);
            joiner.add(String.copyValueOf(word));
        }
        return joiner.toString();
    }
}
