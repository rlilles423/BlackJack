package lilles.rein;

import javafx.scene.image.Image;

public class Card {
	private int value;
	private String suit;
	private boolean placed;
	private Image img;
	private String color;
	
	
	Card(int v, String s, Image pic) {
		value = v;
		suit = s;
		img = pic;
		
		
		
	}
	
	public int getValue() { 
		return value;
	}
	
	public String getSuit() { 
		return suit;
	}
	
	public Image getImage() { 
		return img;
	}
	
	
	@Override
	public String toString() {
		return value + "-" + suit;
	}
	
}
