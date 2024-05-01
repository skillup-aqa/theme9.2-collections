package ua.skillup.isogram;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IsogramCheckerTests {
    @Test
    public void testIsogramPositive() {
        assertTrue(IsogramChecker.isIsogram("abc"));
    }

    @Test
    public void testIsogramNegative() {
        assertFalse(IsogramChecker.isIsogram("banana"));
    }

    @Test
    public void testIsogramEmpty() {
        assertFalse(IsogramChecker.isIsogram(""));
    }
}
