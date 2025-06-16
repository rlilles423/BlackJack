package lilles.rein;

import javafx.scene.image.Image;

public class Card {
	private int value;
	private String suit;
	private Image img;

	
	/**
	 * constructor for a Card
	 * @param v integer value of the card
	 * @param s String for the suit of the card
	 * @param pic Image corresponding to the value and suit of the card
	 */
	Card(int v, String s, Image pic) {
		value = v;
		suit = s;
		img = pic;
		
		
		
	}
	
	/**
	 * get the value of the card
	 * @return the integer value of the card
	 */
	public int getValue() { 
		return value;
	}
	
	/**
	 * get the suit of the card
	 * @return the String suit of the card
	 */
	public String getSuit() { 
		return suit;
	}
	
	/**
	 * get the image of the card
	 * @return the Image that the card has
	 */
	public Image getImage() { 
		return img;
	}
	
	
	/**
	 * return the card as a String
	 */
	@Override
	public String toString() {
		return value + "-" + suit;
	}
	
}
