package Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String currentPile = "K";
        String placePile;
        int address;
        int moves = 0;

        Card storage = new Card(false);

        final Pile DeckOfCards = new Pile();
        final ArrayList<Pile> ClockPile = new ArrayList<>();
        List<String> ranks = Card.getValidRanks();

        Pile.CreateClock(ClockPile);
        Pile.SplitDeck(DeckOfCards, ClockPile);

        System.out.println("________Piles Before Game Started________");
        printClock(ClockPile, ranks);

        //maximum loop is 52 moves in a perfect case
        for (int i = 1; i <= 52; i++) {
            address = ranks.indexOf(currentPile);
            storage = ClockPile.get(address).deck.get(0);
            boolean Complete = storage.getMoved();
            if (!Complete) {
                ClockPile.get(address).deck.remove(storage);
                placePile = storage.getRank();
                address = ranks.indexOf(placePile);
                ClockPile.get(address).deck.add(storage);
                storage.setMoved(true);

                //System.out.println("Added " + storage + " to Pile " + placePile);

                currentPile = storage.getRank();
                moves++;
            } else break;
        }
        System.out.println("________Piles After Game Ended________");
        printClock(ClockPile, ranks);
        System.out.println("Total Moves: " + moves + ", Last Card Moved: " + storage);
    }

    private static void printClock(ArrayList<Pile> ClockPile, List<String> ranks) {
        for (int i = 0; i <= 12; i++) {
            String rank = ranks.get(i);
            System.out.println("Pile: " + rank + ": " + ClockPile.get(i));
        }
    }
}


