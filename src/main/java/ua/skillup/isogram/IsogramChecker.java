package ua.skillup.isogram;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class IsogramChecker {
    /**
     * Checks if the input string is an isogram.
     * An isogram is a word that has no repeating letters.
     * Empty string is not an isogram.
     * @param input input string
     * @return true if the input string is an isogram, false otherwise
     */
    public static boolean isIsogram(String input) {
        ArrayList<Character> letters = new ArrayList<>();
        if (Objects.equals(input, "")) {
        return false;}
        for (int i = 0; i<input.length(); i++) {
            letters.add(input.charAt(i));
        }
        boolean b = input.length() == letters.stream().distinct().count();
        return b;
    }
}
