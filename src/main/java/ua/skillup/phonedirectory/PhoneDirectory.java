package ua.skillup.phonedirectory;

import java.util.List;

public class PhoneDirectory {
    /**
     * Adds a new entry to the phone directory.
     *
     * @param name  the name of the person
     * @param phone the phone number of the person
     * @throws IllegalArgumentException if the phone number already exists in the phone directory
     */
    public void addEntry(String name, String phone) {
        // implementation
    }

    /**
     * Returns the phone number of the person with the given name.
     *
     * @param name the name of the person
     * @return the list of phone numbers and names matching the given name
     * or an empty list if the person with the given name does not exist in the phone directory
     */
    public List<String> getPhone(String name) {
        // implementation
        return null;
    }

    /**
     * Returns the name of the person with the given phone number.
     *
     * @param phone the phone number of the person
     * @return the name of the person or null if the person with the given phone number does not exist in the phone directory
     */
    public String getName(String phone) {
        // implementation
        return "";
    }

    /**
     * Removes the entry with the given name from the phone directory.
     *
     * @param phone the phone number of the person
     * @return true if the entry was removed, false if the entry with the given name does not exist in the phone directory
     */

    public boolean removeEntry(String phone) {
        // implementation
        return false;
    }

    /**
     * Updates the name of the person with the given phone number.
     *
     * @param phone the phone number of the person
     * @param name  the new name of the person
     */
    public void updateName(String phone, String name) {
        // implementation
    }

    @Override
    public String toString() {
        return null;
    }
}
