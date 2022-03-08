package Test;

import java.util.*;

public class Pile {
    String name;
    public ArrayList<Card> deck;

    //constructor for Creating a Pile including A Deck with 52 Cards (without Jokers)
    public Pile() {
        List<String> suits = Card.getValidSuits();
        List<String> ranks = Card.getValidRanks();
        deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit, false));

            }
        }
    }

    //Constructor for Creating Pile which is empty for Clock
    public Pile(String name) {
        this.name = name;
        deck = new ArrayList<>();
    }

    //method to populate the Piles using the deck of cards
    public static void SplitDeck(Pile p, ArrayList<Pile> clock) {
        for (int j = 0; j < 13; j++) {
            for (int i = 0; i < 4; i++) {
                int index = (int) (Math.random() * p.deck.size());
                Card c = p.deck.get(index);
                p.deck.remove(index);
                clock.get(j).deck.add(c);
            }
        }
    }

    public static void CreateClock(ArrayList clock) {
        List<String> ranks = Card.getValidRanks();
        for (String rank : ranks) {
            clock.add(new Pile(rank));
        }

    }

    public String toString() {
        return ("" + deck);
    }
}
