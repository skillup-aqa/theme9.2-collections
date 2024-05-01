package ua.skillup.blackjack.cards;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank, suit);
    }

    public int getValue() {
        return rank.getValue();
    }
}
