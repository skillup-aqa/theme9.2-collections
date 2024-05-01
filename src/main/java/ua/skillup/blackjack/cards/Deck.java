package ua.skillup.blackjack.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    public static LinkedList<Card> generateNewDeck() {
        LinkedList<Card> deck = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(rank, suit)))

                .collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(deck);
        return deck;
    }
}
