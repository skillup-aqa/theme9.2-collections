package ua.skillup.blackjack;

public class Player extends AbstractPlayer {
    private int balance = 1000;


    public Player(String name) {
        super(name);
    }

    public void increaseBalance(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
