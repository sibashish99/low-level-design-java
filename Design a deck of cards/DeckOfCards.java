/*
Design a deck of cards
Constraints and assumptions
>Is this a generic deck of cards for games like poker and black jack?
 - Yes, design a generic deck then extend it to black jack
>Can we assume the deck has 52 cards (2-10, Jack, Queen, King, Ace) and 4 suits?
 -Yes
>Can we assume inputs are valid or do we have to validate them?
 -Assume they're valid

*/


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        String cardValue;
        switch (value) {
            case 1:
                cardValue = "Ace";
                break;
            case 11:
                cardValue = "Jack";
                break;
            case 12:
                cardValue = "Queen";
                break;
            case 13:
                cardValue = "King";
                break;
            default:
                cardValue = Integer.toString(value);
        }
        return cardValue + " of " + suit.toString();
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                Card card = new Card(value, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public int cardsLeft() {
        return cards.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Dealing cards:");
        for (int i = 0; i < 5; i++) {
            Card card = deck.dealCard();
            if (card != null) {
                System.out.println(card.toString());
            } else {
                System.out.println("No more cards left in the deck.");
            }
        }
    }
}
