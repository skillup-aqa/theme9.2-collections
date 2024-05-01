package ua.skillup.blackjack;

import ua.skillup.blackjack.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

abstract public class AbstractPlayer {
    private final List<Card> hand = new ArrayList<>();

    private final String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public int calculateHandValue() {
        return hand.stream().mapToInt(Card::getValue).sum();
    }

    public String getHandAsString() {
        StringJoiner joiner = new StringJoiner("\n");
        hand.forEach(card -> joiner.add(card.toString()));
        return joiner.toString();
    }

    public void clearHand() {
        hand.clear();
    }
}
