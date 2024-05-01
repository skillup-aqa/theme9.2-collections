package ua.skillup.wordcounter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class WordCounterTest {

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"", new HashMap<>()},
                {null, new HashMap<>()},
                {"Hello", Map.of("hello", 1)},
                {"Hello, hello!", Map.of("hello", 2)},
                {"Hello, hello! Hello, world!", Map.of("hello", 3, "world", 1)},
                {"Hello, hello! Hello, world! Water-based", Map.of("hello", 3, "world", 1, "water-based", 1)},
        };
    }

    @Test(dataProvider = "testData")
    public void testCountWords(String input, Map<String, Integer> expected) {
        assertEquals(WordCounter.countWords(input), expected);
    }
}
