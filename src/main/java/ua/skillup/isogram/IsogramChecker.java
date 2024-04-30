package ua.skillup.isogram;

import java.util.Set;

public class IsogramChecker {
    public static boolean isIsogram(String input) {
        return Set.of(input.toCharArray()).size() == input.length();
    }
}
