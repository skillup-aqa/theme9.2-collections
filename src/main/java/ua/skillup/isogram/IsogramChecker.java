package ua.skillup.isogram;

import java.util.HashSet;
import java.util.Set;

public class IsogramChecker {
    /**
     * Checks if the input string is an isogram.
     * An isogram is a word that has no repeating letters.
     * Empty string is not an isogram.
     * @param input input string
     * @return true if the input string is an isogram, false otherwise
     */
    public static boolean isIsogram(String input) {
        if (input.isEmpty()) {
            return false;
        }

        Set<Character> charSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }

        return true;
    }
}
