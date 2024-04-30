package ua.skillup.phonedirectory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PhoneDirectoryTests {
    PhoneDirectory phoneDirectory;

    @BeforeMethod
    public void setUp() {
        phoneDirectory = new PhoneDirectory();
    }

    @Test
    public void testAddEntry() {
        phoneDirectory.addEntry("John Doe", "1234567890");
        assertEquals(phoneDirectory.getName("1234567890"), "John Doe");
    }

    @Test
    public void testAddEntryWithExistingPhone() {
        phoneDirectory.addEntry("John Doe", "1234567890");
        assertThrows(IllegalArgumentException.class, () -> phoneDirectory.addEntry("Jane Doe", "1234567890"));
    }

    @Test
    public void testGetPhoneForMissingName() {
        assertEquals(phoneDirectory.getPhone("John Doe").size(), 0);
    }

    @Test
    public void testGetNameForMissingPhone() {
        assertNull(phoneDirectory.getName("1234567890"));
    }

    @Test
    public void testRemoveEntry() {
        phoneDirectory.addEntry("John Doe", "1234567890");
        assertTrue(phoneDirectory.removeEntry("1234567890"));
        assertNull(phoneDirectory.getName("1234567890"));
    }

    @Test
    public void testRemoveEntryForMissingPhone() {
        assertFalse(phoneDirectory.removeEntry("1234567890"));
        assertNull(phoneDirectory.getName("1234567890"));
    }

    @Test
    public void testUpdateName() {
        phoneDirectory.addEntry("John Doe", "1234567890");
        phoneDirectory.updateName("1234567890", "Jane Doe");
        assertEquals(phoneDirectory.getName("1234567890"), "Jane Doe");
    }
}
