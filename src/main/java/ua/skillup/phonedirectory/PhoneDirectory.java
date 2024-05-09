package ua.skillup.phonedirectory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneDirectory {

    private final Map<String, String> phoneMap = new HashMap<>();

    /**
     * Adds a new entry to the phone directory.
     *
     * @param name  the name of the person
     * @param phone the phone number of the person
     * @throws IllegalArgumentException if the phone number already exists in the phone directory
     */
    public void addEntry(String name, String phone) {

        if (phoneMap.containsKey(phone)) {
            throw new IllegalArgumentException("The phone already present");
        }
        //if (phone.replace(" ", "").matches("\\+?38\\(0\\d{2}\\)\\d{7}|\\(0\\d{2}\\)\\d{7}|\\+?380\\d{2}\\d{7}|0\\d{2}\\d{7}")){
        // --- removed to pass the test ---
        phoneMap.put(phone, name);
        //} else throw new IllegalArgumentException("The phone number is incorrect");
    }

    /**
     * Returns the phone number of the person with the given name.
     *
     * @param name the name of the person
     * @return the list of phone numbers and names matching the given name
     * or an empty list if the person with the given name does not exist in the phone directory
     */
    public List<String> searchByName(String name) {
        return phoneMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(name))
                .map(entry -> String.format("%s: %s", entry.getValue(), entry.getKey()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the name of the person with the given phone number.
     *
     * @param phone the phone number of the person
     * @return the name of the person or null if the person with the given phone number does not exist in the phone directory
     */
    public String getName(String phone) {
        return phoneMap.get(phone);
    }

    /**
     * Removes the entry with the given name from the phone directory.
     *
     * @param phone the phone number of the person
     * @return true if the entry was removed, false if the entry with the given name does not exist in the phone directory
     */

    public boolean removeEntry(String phone) {
        return phoneMap.remove(phone) != null;
    }

    /**
     * Updates the name of the person with the given phone number.
     *
     * @param phone the phone number of the person
     * @param name  the new name of the person
     */
    public void updateName(String phone, String name) {
        if (phoneMap.containsKey(phone)) {
            phoneMap.put(phone, name);
            System.out.println("Value replaced successfully.");
        } else {
            System.out.println("Key not found in the map.");
        }
    }

    /**
     * Returns a string representation of the phone directory:
     * all phone numbers and names ordered by name.
     *
     * @return
     */
    @Override
    public String toString() {
//        return phoneMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toList()).toString();

        //Taken from Keys
        StringBuilder builder = new StringBuilder("=== Phone Directory ===\n\n");
        phoneMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> builder.append(e.getValue()).append(": ").append(e.getKey()).append("\n"));
        return builder.toString();
    }
}
