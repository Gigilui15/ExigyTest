package Test;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    String name;
    public ArrayList<Card> deck;

    //Constructor for Creating a Pile including A Deck with 52 Cards (without Jokers)
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

    //Populating the Piles using the deck of cards
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

    //Creating The Clock For the Game With Piles Named After Each Rank
    public static void CreateClock(ArrayList<Pile> clock) {
        List<String> ranks = Card.getValidRanks();
        for (String rank : ranks) {
            clock.add(new Pile(rank));
        }

    }

    @Override
    public String toString() {
        return ("" + deck);
    }
}
