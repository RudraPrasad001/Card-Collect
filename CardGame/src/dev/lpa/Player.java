package dev.lpa;

import java.util.List;

public class Player {
    String name;
    List<Card> deck = Card.getStandardDeck();
    int lootTook=0;
    public Player(String name)
    {
        this.name=name;
    }
    public Card getFirstCard()
    {
        return deck.get(0);
    }



}
