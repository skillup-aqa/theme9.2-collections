package ua.skillup.blackjack.ui;

import ua.skillup.blackjack.AbstractPlayer;
import ua.skillup.blackjack.Player;

abstract public class UI {
    abstract public void showMessage(String message);

    abstract public void showWelcomeMessage();

    abstract public String askPlayersName();

    abstract public boolean askForContinue(Player player);

    abstract public int askForBet(Player player);

    abstract public void showHand(AbstractPlayer player);

    abstract public boolean playerWantsToHit();
}
