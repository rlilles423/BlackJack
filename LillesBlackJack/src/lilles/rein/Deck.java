package lilles.rein;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Deck {
	
	ArrayList<Card> cards = new ArrayList<>();
	
	
	public Deck() {
		
		String suit = "suit";
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
			
			
			
			for (int num = 2; num <= 10; num++) {
				
				String img = "/images/" + num + "_of_" + suit + ".png";
				System.out.println(img);
				
				Image image3 = new Image(getClass().getResourceAsStream(img));
				Card c = new Card(num, suit, image3);
				cards.add(c);
			}
			
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
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card get(int idx) {
		return cards.get(idx);
	}
	
	public void remove(int idx) {
		cards.remove(idx);
	}

}
