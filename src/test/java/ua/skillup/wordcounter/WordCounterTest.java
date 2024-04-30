package ua.skillup.wordcounter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WordCounterTest {

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"", 0},
                {null, 0},
                {"Hello", 1},
                {"Hello, world!", 2},
                {"The sentence! And another one.", 5}
        };
    }

    @Test(dataProvider = "testData")
    public void testCountWords(String input, int expected) {
        assertEquals(WordCounter.countWords(input), expected);
    }
}
