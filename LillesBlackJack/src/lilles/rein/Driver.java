package lilles.rein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Driver {
	
	public static void main(String[] args) {
	
	ArrayList<Card> deck = new ArrayList<>();
	
	for (int i = 1; i <= 13; i++) {
		
		//deck.add(new Card(i,"Spades"));
		
		
		}
	for (int i = 1; i <= 13; i++) {
		
		//deck.add(new Card(i,"Hearts"));
		
		
		}
	for (int i = 1; i <= 13; i++) {
		
		//deck.add(new Card(i,"Clubs"));
		
		
		}
	for (int i = 1; i <= 13; i++) {
		
		//deck.add(new Card(i,"Diamonds"));
		
		
		}
	
	Collections.shuffle(deck);
	
	for (Card card: deck) {
		System.out.print(card + " ");
	}
	
		
	}
	
}