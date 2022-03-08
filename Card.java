package Test;

import java.util.Arrays;
import java.util.List;

public class Card {
    String rank, suit;
    boolean moved;

    public Card(String rank, String suit, boolean moved) {
        setRank(rank);
        setSuit(suit);
        this.moved = moved;
    }

    public Card(boolean moved) {
        this.moved = moved;
    }

    public String getRank() {
        return rank;
    }

    public boolean getMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setRank(String rank) {
        List<String> validRanks = getValidRanks();

        if (validRanks.contains(rank))
            this.rank = rank;
        else
            throw new IllegalArgumentException("Rank is not Valid");
    }

    public void setSuit(String suit) {
        List<String> validSuits = getValidSuits();

        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException("Suit is not Valid");
    }

    public static List<String> getValidRanks() {
        return Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K");
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("D", "S", "C", "H");
    }

    @Override
    public String toString() {
        return "" + rank + "" + suit;
    }
}
