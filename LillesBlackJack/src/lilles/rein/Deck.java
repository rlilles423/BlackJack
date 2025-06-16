package lilles.rein;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Deck {
	
	// the deck is an arraylist of cards
	ArrayList<Card> cards = new ArrayList<>();
	
	
	/**
	 * constructor for the deck, adds all 52 cards to the deck
	 */
	public Deck() {
		
		
		String suit = "suit";
		// create all 12 cards for each suit
		for (int i = 0; i < 4; i++) {
			
			if (i == 0) {
				suit = "clubs";
			}
			
			if (i == 1) {
				suit = "spades";
			}
			
			if (i == 2) {
				suit = "diamonds";
			}
			
			if (i == 3) {
				suit = "hearts";
			}
			
			
			// create all the number cards and add their images
			for (int num = 2; num <= 10; num++) {
				
				String img = "/images/" + num + "_of_" + suit + ".png";
				System.out.println(img);
				
				Image image3 = new Image(getClass().getResourceAsStream(img));
				Card c = new Card(num, suit, image3);
				cards.add(c);
			}
			
			// create all the face cards and add their images
			String[] faceCards = {"ace","jack","queen","king"};
			int[] vals = {1,10,10,10};
			
			for (int f = 0; f < 4; f ++) {
				String img = "/images/" + faceCards[f] + "_of_" + suit + ".png";
				System.out.println(img);
				
				
				Image image3 = new Image(getClass().getResourceAsStream(img));
				Card c = new Card(vals[f], suit, image3);
				cards.add(c);
			}
			
			
		}
	}
	
	/**
	 * shuffle the deck into a random order
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Give the value of a card in a given position in the deck
	 * @param idx the position of the card in the deck
	 * @return
	 */
	public Card get(int idx) {
		return cards.get(idx);
	}
	
	/**
	 * remove a card from the deck
	 * @param idx the position of the card being removed
	 */
	public void remove(int idx) {
		cards.remove(idx);
	}

}
