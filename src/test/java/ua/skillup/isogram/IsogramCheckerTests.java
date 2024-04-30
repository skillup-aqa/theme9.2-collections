package ua.skillup.isogram;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class IsogramCheckerTests {
    @Test
    public void testIsogramPositive() {
        assertFalse(IsogramChecker.isIsogram("ambidextrously"));
    }

    @Test
    public void testIsogramNegative() {
        assertFalse(IsogramChecker.isIsogram("banana"));
    }
}
