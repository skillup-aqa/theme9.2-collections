package ua.skillup;

import ua.skillup.cart.Cart;
import ua.skillup.cart.Product;
import ua.skillup.isogram.IsogramChecker;
import ua.skillup.phonedirectory.PhoneDirectory;
import ua.skillup.wordcounter.WordCounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        phone.addEntry("To Replace", "56789");
        System.out.println(phone);
        phone.updateName("2323", "Pupkin");
        phone.updateName("56789", "Is Replaced");
        System.out.println(phone);
        System.out.println(phone.searchByName("Ni"));

        System.out.println("--- Words counter ---");
        String text = "This is a sample-pemple sentence, with some words and! some is possibe sentence.";
        System.out.println(WordCounter.countWords(text));

        System.out.println("--- Cart ---");
        Cart listForProduct = new Cart();
        Product cheese = new Product("Cheese", 2.5);
        Product salo = new Product("Salo", 3.8);
        Product bread = new Product("Bread", 1.74);
        Product water = new Product("Water", 0.2);

        listForProduct.addProduct(cheese, 2);
        listForProduct.addProduct(salo, 3);
        listForProduct.addProduct(bread, 2);
        listForProduct.addProduct(water, 10);
        listForProduct.setProductQuantity(salo, 4);

        listForProduct.setProductQuantity(water, 0);
        // System.out.println(listForProduct.removeProduct(water));
        System.out.println(listForProduct.removeProduct(bread));
        System.out.println(listForProduct.generateBill());


    }
}
