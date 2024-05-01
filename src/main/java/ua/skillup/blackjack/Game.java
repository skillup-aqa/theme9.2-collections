package ua.skillup.blackjack;

import ua.skillup.blackjack.cards.Card;
import ua.skillup.blackjack.ui.ConsoleUI;
import ua.skillup.blackjack.ui.UI;

public class Game {

    private final UI ui = new ConsoleUI();

    /**
     * Main game loop
     * The game logic is implemented here.
     * All the UI logic is implemented in the UI class.
     * This allows to easily switch between different UI implementations.
     */
    public void play() {
        ui.showWelcomeMessage();

        Dealer dealer = new Dealer();
        Player player = new Player(ui.askPlayersName());

        while (player.getBalance() > 0 && ui.askForContinue(player)) {
            player.clearHand();
            dealer.clearHand();

            int bet = ui.askForBet(player);

            // Dealing two cards to the player
            player.addCardToHand(dealer.dealCard());
            player.addCardToHand(dealer.dealCard());

            // Dealing card to the dealer
            dealer.addCardToHand(dealer.dealCard());

            ui.showHand(player);

            int BLACKJACK = 21;
            if (player.calculateHandValue() == BLACKJACK) {
                playerWins(player, bet, "Congratulations! You have Blackjack!");
                continue;
            }

            ui.showHand(dealer);

            while (player.calculateHandValue() <= BLACKJACK) {
                if (ui.playerWantsToHit()) {
                    Card card = dealer.dealCard();
                    ui.showMessage("You have drawn a " + card);
                    player.addCardToHand(card);
                } else {
                    break;
                }
            }

            if (player.calculateHandValue() > BLACKJACK) {
                playerLoses(player, bet, "You have busted! Dealer wins!");
                continue;
            }

            int DEALER_STANDS = 17;
            while (dealer.calculateHandValue() < DEALER_STANDS) {
                Card card = dealer.dealCard();
                ui.showMessage("Dealer has drawn a " + card);
                dealer.addCardToHand(card);
            }

            ui.showHand(dealer);
            ui.showHand(player);

            if (dealer.calculateHandValue() > BLACKJACK || player.calculateHandValue() > dealer.calculateHandValue()) {
                playerWins(player, bet, "Congratulations! You win!");
            } else if (player.calculateHandValue() < dealer.calculateHandValue()) {
                playerLoses(player, bet, "Dealer wins!");
            } else {
                ui.showMessage("It's a tie!");
            }
        }

        if (player.getBalance() <= 0) {
            ui.showMessage("You have run out of money. Game over!");
        } else {
            ui.showMessage("Thank you for playing! Your final balance is $" + player.getBalance());
        }
    }

    private void playerWins(Player player, int bet, String message) {
        ui.showMessage(message);
        player.increaseBalance(Math.round(bet * 1.5f));
    }

    private void playerLoses(Player player, int bet, String message) {
        ui.showMessage(message);
        player.withdraw(bet);
    }

    public static void main(String[] args) {
        new Game().play();
    }
}
