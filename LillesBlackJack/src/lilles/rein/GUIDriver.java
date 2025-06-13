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

	@Override
	public void start(Stage stage) throws Exception {
		
		
		
				
		VBox root = new VBox(30);
		root.setAlignment(Pos.TOP_CENTER);
		
		Label wlcm = new Label("Welcome to blackJack");
		wlcm.setAlignment(Pos.CENTER);
		
		Deck deck = new Deck();
		
		
		Image img = new Image("/images/blank.png", 100, 0, true, false);
		ImageView imageView = new ImageView(img);
		
		
		// Create all buttons
		Button btnDeal = new Button("Deal");
		Button btnHit = new Button("Hit");
		Button btnStand = new Button("Stand");
		Button btnEnd = new Button("End");
		
		//Hold the buttons
		HBox btnHolder = new HBox(10);
		btnHolder.getChildren().addAll(btnDeal, btnHit, btnStand,btnEnd);
		btnHolder.setAlignment(Pos.CENTER);
		
		// Create a spot for the cards in play
		ArrayList<Card> dealerCards = new ArrayList<>();
		HBox dCardHld = new HBox(10);
		
		ArrayList<Card> playerCards = new ArrayList<>();
		HBox pCardHld = new HBox(10);
		
		HBox cardHld = new HBox(40);
		cardHld.getChildren().addAll(pCardHld,dCardHld);
		cardHld.setAlignment(Pos.CENTER);
		//Value of where you are in the deck
		
		
		btnDeal.setOnAction(e -> {
			deck.shuffle();
			
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
			ImageView dImg1view = new ImageView(dealerCards.get(0).getImage());
			ImageView dImg2view = new ImageView(dealerCards.get(1).getImage());
			
			dCardHld.getChildren().addAll(dImg1view,dImg2view);
			
			//Player cards
			ImageView pImg1view = new ImageView(playerCards.get(0).getImage());
			ImageView pImg2view = new ImageView(playerCards.get(1).getImage());
			
			pCardHld.getChildren().addAll(pImg1view,pImg2view);
			
		});
		
		
		root.getChildren().add(wlcm);
		root.getChildren().add(imageView);
		root.getChildren().add(btnHolder);
		root.getChildren().add(cardHld);
		
		Scene scene = new Scene(root, 1000, 800);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();

	}

}