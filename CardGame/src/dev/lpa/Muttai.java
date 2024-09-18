package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Muttai {
    Scanner s = new Scanner(System.in);
    String name;
    Card card1;
    Card card2;

    int i =0;
    List<Card> loot = new ArrayList<>();

    public Muttai(String name) {
        this.name = name;
        Collections.shuffle(player1.deck);
        Collections.shuffle(player2.deck);
    }

    Player player1 = new Player("BigMan");
    Player player2 = new Player("Computer");

    public void startGame()
    {
        while(!player1.deck.isEmpty()&&!player2.deck.isEmpty())
        {
            card1=player1.getFirstCard();
            card2=player2.getFirstCard();
            if(i%2==0){
            loot.add(card1);
                loot.add(card2);

                if(Card.sameNumberOrFace(player1.deck.get(0),player2.deck.get(0)))
                {
                    player2.deck.addAll(loot);
                    System.out.println("computer took all the loot");

                    loot.clear();
                }

            }

            else {
                loot.add(player2.deck.get(0));
                loot.add(player1.deck.get(0));
                if(Card.sameNumberOrFace(player1.deck.get(0),player2.deck.get(0)))
                {
                    player1.deck.addAll(loot);
                    System.out.println("u took all the loot");
                    player1.lootTook++;
                    loot.clear();

                }
            }

            player2.deck.remove(0);
            player1.deck.remove(0);
            i++;
        }
        if(player1.deck.isEmpty())
        {
            System.out.println(player1.name+"Lost all of their cards to "+player2.name+"You lose!!");
        }
        else {
            System.out.println(player2.name+"Lost all of their cards to "+player1.name+"You WIN!!");
        }

    }
    public void startAdvancedGame()
    {
        while(!player1.deck.isEmpty()&&!player2.deck.isEmpty())
        {
            card1=player1.getFirstCard();
            card2=player2.getFirstCard();

            System.out.println("Press enter to place a card.Cards Remaining : "+player1.deck.size());
            String a = s.nextLine();
           System.out.printf("%s is placed by %s\n ",card1,player1.name);
            player1.deck.remove(0);
            player2.deck.remove(0);
            if(!loot.isEmpty()&&Card.sameNumberOrFace(loot.get(loot.size()-1),card1))
            {
                loot.add(card1);
                player1.deck.addAll(loot);
                loot.clear();
                player1.lootTook++;
                System.out.println("All the loot has been taken by you\n");
            }
            else {
                System.out.println("\n");
                loot.add(card1);
            }

            System.out.printf("%s is placed by %s \n ",card2,player2.name);

            if(!loot.isEmpty()&&Card.sameNumberOrFace(loot.get(loot.size()-1),card2))
            {
                loot.add(card2);
                player2.deck.addAll(loot);
                loot.clear();
                player2.lootTook++;
                System.out.println("All the loot has been taken by the computer\n");
            }
            else {
                System.out.println("\n");
                loot.add(card2);
            }
        }

        if(player1.deck.isEmpty())
        {
            System.out.println(player1.name+" Lost all of their cards to "+player2.name+". You lose!!");
        }
        else {
            System.out.println(player2.name+" Lost all of their cards to "+player1.name+". You WIN!!");
        }
        System.out.printf("""
                
                Match Summary:
                    Total number of times loot were taken by the Player is %d.
                
                    Total number of times loot were taken by the Computer is %d.
                
                """,player1.lootTook,player2.lootTook);
    }

}
