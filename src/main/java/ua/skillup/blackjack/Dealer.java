package ua.skillup.blackjack;

import ua.skillup.blackjack.cards.Card;
import ua.skillup.blackjack.cards.Deck;

import java.util.LinkedList;

public class Dealer extends AbstractPlayer {
    private final LinkedList<Card> deck = Deck.generateNewDeck();

    public Dealer() {
        super("Dealer");
    }

    public Card dealCard() {
        return deck.poll();
    }
}
