package Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Game Always starts at Pile K
        String currentPile = "K";
        //PlacePile holds the Pile name/Card Rank where the Card must be placed
        String placePile;
        //Address holds the value bound to the Pile in the Arraylist
        int address;
        int moves = 0;

        //Card Created to act as a Storage for Moving Card from One pile to Another
        Card storage = new Card(false);

        //Deck of 52 Cards is Created
        final Pile DeckOfCards = new Pile();
        //Clock ArrayList is Created
        final ArrayList<Pile> ClockPile = new ArrayList<>();
        List<String> ranks = Card.getValidRanks();


        Pile.CreateClock(ClockPile);
        Pile.SplitDeck(DeckOfCards, ClockPile);

        System.out.println("________Piles Before Game Started________");
        printClock(ClockPile, ranks);

        //maximum loop is 52 moves in a perfect case
        for (int i = 0; i <= 51; i++) {
            //Sorting Algorithm for Game with Detection to stop unnecessary looping through boolean moved in Card
            address = ranks.indexOf(currentPile);
            storage = ClockPile.get(address).deck.get(0);
            boolean Complete = storage.getMoved();
            if (!Complete) {
                ClockPile.get(address).deck.remove(storage);
                placePile = storage.getRank();
                address = ranks.indexOf(placePile);
                ClockPile.get(address).deck.add(storage);
                storage.setMoved(true);

                //for Testing which Cards Are being Moved
                //System.out.println("Added " + storage + " to Pile " + placePile);

                currentPile = storage.getRank();
                moves++;

            } else break;
        }
        //Print Piles with Cards After Game Ends
        System.out.println("________Piles After Game Ended________");
        printClock(ClockPile, ranks);
        //Prints Total number of moves and the last card revealed/moved
        System.out.println("Total Moves: " + moves + ", Last Card Moved: " + storage);
    }

    //Prints Each Pile With The Cards Shown Inside each Pile
    private static void printClock(ArrayList<Pile> ClockPile, List<String> ranks) {
        for (int i = 0; i <= 12; i++) {
            String rank = ranks.get(i);
            System.out.println("Pile: " + rank + ": " + ClockPile.get(i));
        }
    }
}


