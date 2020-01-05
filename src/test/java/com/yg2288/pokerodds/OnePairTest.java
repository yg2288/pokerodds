package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class OnePairTest {
    public OnePair getHand1() {
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        pair.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        ArrayList<Card> rest = new ArrayList<>();
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(pair, rest);
    }

    public OnePair getHand2() {
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Card.Suit.SPADES, Card.Rank.TWO));
        pair.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        ArrayList<Card> rest = new ArrayList<>();
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(pair, rest);
    }

    public OnePair getHand3() {
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        pair.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        ArrayList<Card> rest = new ArrayList<>();
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(pair, rest);
    }

    @Test
    public void onePairTest1() {
        OnePair hand = getHand1();
        assertEquals(hand.getPair().get(0).getRank(), hand.getPair().get(1).getRank());
    }

    @Test
    public void onePairTest2() {
        OnePair hand1 = getHand1();
        OnePair hand2 = getHand1();
        assertEquals(hand1.compareTo(hand2), 0);
    }

    @Test
    public void onePairTest3() {
        OnePair hand1 = getHand1();
        OnePair hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) > 0);
        assertTrue(hand2.compareTo(hand1) < 0);
    }

    @Test
    public void onePairTest4() {
        OnePair hand1 = getHand2();
        OnePair hand2 = getHand3();
        assertEquals(hand1.compareTo(hand2), 0);
    }
}
