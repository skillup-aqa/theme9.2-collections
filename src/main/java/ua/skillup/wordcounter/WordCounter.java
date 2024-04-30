package ua.skillup.wordcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> result = new HashMap<>();

        if (input == null) {
            return result;
        }

        Pattern pattern = Pattern.compile("([a-z]+\\-?[a-z]+)");
        Matcher matcher = pattern.matcher(input.toLowerCase());

        while (matcher.find()) {
            String word = matcher.group();
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return result;
    }
}
