package lilles.rein;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	static boolean hasDelt = false;
	@Override
	public void start(Stage stage) throws Exception {
		
		
		
				
		VBox root = new VBox(30);
		root.setAlignment(Pos.TOP_CENTER);
		
		Label wlcm = new Label("Welcome to blackJack");
		wlcm.setAlignment(Pos.CENTER);
		
		Deck deck = new Deck();
		
		
		Image imgBlank = new Image("/images/blank.png", 100, 0, true, false);
		ImageView imageView = new ImageView(imgBlank);
		
		
		// Create all buttons
		Button btnDeal = new Button("Deal");
		Button btnHit = new Button("Hit");
		Button btnStand = new Button("Stand");
		Button btnNewRound = new Button("New Round");
		
		//Hold the buttons
		HBox btnHolder = new HBox(10);
		btnHolder.getChildren().addAll(btnDeal, btnHit, btnStand,btnNewRound);
		btnHolder.setAlignment(Pos.CENTER);
		
		// Create a spot for the cards in play
		ArrayList<Card> dealerCards = new ArrayList<>();
		HBox dCardHld = new HBox(10);
		
		ArrayList<Card> playerCards = new ArrayList<>();
		HBox pCardHld = new HBox(10);
		
		//display the value of the card pairs
		Label dCardValue = new Label("");
		Label pCardValue = new Label("");
		pCardValue.setAlignment(Pos.CENTER);
		dCardValue.setAlignment(Pos.CENTER);
		
		// hold the pairs of cards with their corresponding value
		VBox dCardandVal = new VBox(10);
		VBox pCardandVal = new VBox(10);
		
		dCardandVal.getChildren().addAll(dCardHld, dCardValue);
		pCardandVal.getChildren().addAll(pCardHld, pCardValue);
		
		
		// hold both pairs of cards and their value along an h box
		HBox cardHld = new HBox(40);
		
		cardHld.getChildren().addAll(dCardandVal,pCardandVal);
		cardHld.setAlignment(Pos.CENTER);
		
		
		
		btnDeal.setOnAction(e -> {
			deck.shuffle();
			if (! hasDelt) {
				btnDeal.setDisable(true);
			}
			
			hasDelt = true;
			
			
			dealerCards.add(deck.get(0));
			deck.remove(0);
			dealerCards.add(deck.get(0));
			deck.remove(0);
			
			playerCards.add(deck.get(0));
			deck.remove(0);
			playerCards.add(deck.get(0));
			deck.remove(0);
			
			//create the images of the cards that were delt
			
			//Dealer cards
			ImageView dImg1view = new ImageView(imgBlank);
			ImageView dImg2view = new ImageView(dealerCards.get(1).getImage());
			
			dCardHld.getChildren().addAll(dImg1view,dImg2view);
			
			//Player cards
			ImageView pImg1view = new ImageView(playerCards.get(0).getImage());
			ImageView pImg2view = new ImageView(playerCards.get(1).getImage());
			
			pCardHld.getChildren().addAll(pImg1view,pImg2view);
			
			//Display their values
			pCardValue.setText("Player Total: " + totalValue(playerCards));
			dCardValue.setText("Dealer Total: " + totalValue(dealerCards));
			
			
			
		});
		
		btnHit.setOnAction(e -> {
			playerCards.add(deck.get(0));
			deck.remove(0);
			pCardValue.setText("Player Total: " + totalValue(playerCards));
			
			ImageView newPlayerCard = new ImageView(playerCards.get(playerCards.size() - 1).getImage());
			pCardHld.getChildren().add(newPlayerCard);
			
		});
		
		btnStand.setOnAction(e -> {
			
			
			
			
			while (totalValue(dealerCards) < 16) {
				dealerCards.add(deck.get(0));
				deck.remove(0);
				dCardValue.setText("Dealer Total: " + totalValue(dealerCards));
				
				ImageView newDealerCard = new ImageView(dealerCards.get(dealerCards.size() - 1).getImage());
				dCardHld.getChildren().add(newDealerCard);
			}
		});
		
		btnNewRound.setOnAction(e -> {
			
		});
		
		root.getChildren().add(wlcm);
		root.getChildren().add(imageView);
		root.getChildren().add(btnHolder);
		root.getChildren().add(cardHld);
		
		Scene scene = new Scene(root, 1000, 800);
		stage.setScene(scene);
		stage.show();

	}

	public static int totalValue(ArrayList<Card> cards) {
		int total = 0;
		for (Card c: cards) {
			total += c.getValue();
		}
		return total;
	}

	public static void main(String[] args) {
		launch();

	}

}