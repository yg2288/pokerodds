package com.yg2288.pokerodds.hand;

import com.yg2288.pokerodds.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayingHand extends Hand {
    protected HandEnum type;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        return true;
    }

    public static int[] getProfile(List<Card> cards) {
        int[] count = new int[13];
        for (Card c : cards)
            count[c.getRank().ordinal()]++;
        int[] profile = new int[5];
        for (int i : count)
            profile[i]++;
        return profile;
    }

    public static List<List<Card>> getBuckets(List<Card> cards) {
        List<List<Card>> buckets = new ArrayList<>();
        for (int i=0; i<13; i++)
            buckets.add(new ArrayList<>());
        for (Card c : cards)
            buckets.get(c.getRank().ordinal()).add(c);
        return buckets;
    }

    public PlayingHand(List<Card> cards) {
        super(cards);
        if (!PlayingHand.isValid(this.cards))
            throw new IllegalArgumentException("Playing hand must contain 5 cards. ");
        setType(HandEnum.UNRANKED);
    }

    @Override
    public boolean addCard(Card c) {
        return false;
    }

    protected void setType(HandEnum type) {
        this.type = type;
    }

    public HandEnum getType() {
        return type;
    }
}
