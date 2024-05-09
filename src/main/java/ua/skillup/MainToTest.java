package ua.skillup;

import ua.skillup.isogram.IsogramChecker;
import ua.skillup.phonedirectory.PhoneDirectory;

public class MainToTest {
    public static void main(String[] args) {
        System.out.println("--- Isogram ---");
        System.out.println(IsogramChecker.isIsogram("bulka"));
        System.out.println(IsogramChecker.isIsogram("bubusik"));


        System.out.println("--- Phone ---");
        PhoneDirectory phone = new PhoneDirectory();
        phone.addEntry("Sasha", "+380950000000");
        phone.addEntry("Eugesha", "+38 066 000 22 33");
        phone.addEntry("Nika", "+38 (067) 111 22 33");
        phone.addEntry("To Remove", "1234");



        System.out.println(phone.getName("+38 066 000 22 33"));

        System.out.println(phone);
        System.out.println(phone.removeEntry("1234"));
        System.out.println(phone);


    }
}
