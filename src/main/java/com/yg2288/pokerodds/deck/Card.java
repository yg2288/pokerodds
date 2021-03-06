package com.yg2288.pokerodds.deck;

public class Card implements Comparable<Card>, Cloneable {
    public enum Suit {
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        String faceValue;
        switch (rank) {
            case ACE:
            case JACK:
            case QUEEN:
            case KING:
                faceValue = rank.name();
                break;
            default:
                faceValue = Integer.toString(rank.getValue());
        }
        return faceValue + " of " + suit.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card c = (Card)o;
        return suit.equals(c.suit) && rank.equals(c.rank);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + rank.getValue();
        result = 31*result + suit.ordinal();
        return result;
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (rank != anotherCard.rank)
            return rank.compareTo(anotherCard.rank);
        return suit.compareTo(anotherCard.suit);
    }

    @Override
    public Card clone() {
        return new Card(this.getSuit(), this.getRank());
    }
}
