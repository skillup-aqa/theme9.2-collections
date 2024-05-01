package ua.skillup.blackjack.ui;

import ua.skillup.blackjack.AbstractPlayer;
import ua.skillup.blackjack.Player;

import java.util.Scanner;

public class ConsoleUI extends UI {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showWelcomeMessage() {
        showMessage("""
                ______ _            _      ___            _  \s
                | ___ \\ |          | |    |_  |          | | \s
                | |_/ / | __ _  ___| | __   | | __ _  ___| | __
                | ___ \\ |/ _` |/ __| |/ /   | |/ _` |/ __| |/ /
                | |_/ / | (_| | (__|   <\\__/ / (_| | (__|   <
                \\____/|_|\\__,_|\\___|_|\\_\\____/ \\__,_|\\___|_|\\_\\
                                                              
                                                              
                Welcome to the game of Blackjack! Let's play!
                                
                Your goal is to get as close to 21 as possible without going over.
                You will be playing against the dealer.
                Cards 2-10 are worth their face value. Face cards are worth 10. Aces are worth 11.
                                
                Good luck!
                """);
    }

    @Override
    public String askPlayersName() {
        showMessage("Please enter your name:");
        return scanner.nextLine();
    }

    @Override
    public boolean askForContinue(Player player) {
        showMessage("Your current balance is $" + player.getBalance());
        showMessage("Do you want to play this round? Type '1' to continue and '0' to exit.");
        return requestAction();
    }

    @Override
    public int askForBet(Player player) {
        showMessage("Please enter your bet:");
        int bet;
        while (true) {
            bet = requestInt();
            if (bet > player.getBalance()) {
                showMessage("You don't have enough money. Please enter a smaller bet.");
            } else if (bet <= 0) {
                showMessage("Bet must be greater than 0. Please enter a valid bet.");
            } else {
                break;
            }
        }
        return bet;
    }

    @Override
    public void showHand(AbstractPlayer player) {
        showMessage("--- " + player.getName() + "'s hand: ---\n" +
                player.getHandAsString() +
                "\nTotal value: " +
                player.calculateHandValue());
    }

    @Override
    public boolean playerWantsToHit() {
        showMessage("Do you want to hit (1) or stand (0)?");
        return requestAction();
    }

    private boolean requestAction() {
        int action = requestInt();
        while (action < 0 || action > 1) {
            showMessage("Invalid input. Please enter 1 or 0.");
            action = requestInt();
        }
        return action == 1;
    }

    private int requestInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Discard the invalid input
        }

        return scanner.nextInt();
    }
}
