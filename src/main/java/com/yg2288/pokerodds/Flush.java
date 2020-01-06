package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class Flush extends PlayingHand {
    public static final HandEnum type = HandEnum.FLUSH;
    private Card.Suit flushSuit;

    public static boolean isFlush(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        return cards.stream().allMatch(c -> c.getSuit() == cards.get(0).getSuit());
    }

    public Flush(List<Card> cards) {
        super(cards);
        if (!isFlush(cards))
            throw new IllegalArgumentException("Not a flush. ");

        Collections.sort(this.cards, Collections.reverseOrder());
        flushSuit = this.cards.get(0).getSuit();
    }

    public Card.Suit getFlushSuit() {
        return flushSuit;
    }
}
