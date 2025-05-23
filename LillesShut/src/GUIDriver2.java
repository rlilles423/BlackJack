import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUIDriver2 extends Application {

	Die d1 = new Die(6);
	Die d2 = new Die(6);

	int roundNum = 1;

	int p1Score = 0;
	int p2Score = 0;

	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		// Create the Button objects for each marker
		Button[] tileBtns = new Button[9];
		for (int i = 0; i < tileBtns.length; i++) {
			Button button = new Button(String.valueOf(i + 1));
			button.setStyle("-fx-background-color: #FFFFFF;");
			tileBtns[i] = button;
		}

		// Create the markers
		Tile[] markers = new Tile[9];
		for (int i = 0; i < markers.length; i++) {
			markers[i] = new Tile(i + 1);
		}

		HBox btnBox = new HBox(10);
		for (Button b : tileBtns) {
			btnBox.getChildren().add(b);

			// add event handler
			b.setOnAction(e -> {
				int number = Integer.valueOf(b.getText());
				if (!markers[(number - 1)].isDown()) {
					if (!markers[(number - 1)].isSelected()) {
						// set the color for selection
						b.setStyle("-fx-background-color: #DAF7A6;");
						markers[(number - 1)].select();
					} else {
						b.setStyle("-fx-background-color: #FFFFFF;");
						markers[(number - 1)].deselect();
					}
				}
			});
		} // end of event handler for tile section buttons

		Button btnRoll = new Button("Roll 2 die");

		Label dieResult = new Label("");

		btnRoll.setOnAction(e -> {
			if (btnRoll.getText().equals("Roll 2 die")) {
				int sumDie = d1.roll() + d2.roll();
				dieResult.setText(String.valueOf(sumDie));
				btnRoll.setDisable(true);
			}
			if (btnRoll.getText().equals("Roll 1 die")) {
				int sumDie = d1.roll();
				dieResult.setText(String.valueOf(sumDie));
				btnRoll.setDisable(true);
			}

			// check if the combination is possible

		});

		Label dieResultPossible = new Label("");

		Button lockIn = new Button("Lock IN");
		lockIn.setOnAction(e -> {
			// determine the sum of the selected tiles
			int sum = 0;
			for (Tile t : markers) {
				if (t.isSelected()) {
					sum += t.getValue();
				}
			}
			System.out.println(sum);
			System.out.println(Integer.valueOf(dieResult.getText()));
			dieResultPossible.setText("Valid Pair");

			if (sum == Integer.valueOf(dieResult.getText())) {
				// disable the buttons that are selected and change color
				for (int i = 0; i < markers.length; i++) {
					if (markers[i].isSelected()) {
						markers[i].deselect();
						markers[i].shut();
						tileBtns[i].setStyle("-fx-background-color:#ff99ff;");
						tileBtns[i].setDisable(true);
					}
				}
				
				// only roll 1 die if 7 8 9 are down
				if (markers[6].isDown() && markers[7].isDown() && markers[8].isDown()) {
					btnRoll.setText("Roll 1 die");
					dieResultPossible.setText("You are now rolling 1 die!");
					
				}
					
					
				// renable the roll
				dieResult.setText("");
				btnRoll.setDisable(false);

			} else {
				// clear the state of the buttons and provide feedback
				dieResultPossible.setText("Invalid Pair");
				System.out.println("Bad match");
			}

		});

		// Different rounds
		Label round = new Label("Round 1");

		// Different players
		Label p1 = new Label("Player 1 score: 0");
		Label p2 = new Label("Player 2 score: 0");

		// Done button
		Button done = new Button("Done");
		done.setOnAction(e -> {
			int sum = 0;
			for (int i = 0; i < markers.length; i++) {
				// add not down tiles to the score
				if (!markers[i].isDown()) {
					sum += markers[i].getValue();
				}

				// renenable all of the tiles
				tileBtns[i].setStyle("-fx-background-color: #FFFFFF;");
				markers[(i)].deselect();
				tileBtns[i].setDisable(false);
				markers[i].putUp();

				// renenable the roll
				dieResult.setText("");
				btnRoll.setDisable(false);

			}
			// add unselected ones to the score
			if (roundNum%2 != 0) {
				p1Score += sum;
				p1.setText("Player 1 score: " + p1Score);
			}
			
			else {
				p2Score += sum;
				p2.setText("Player 2 score: " + p2Score);
			}
			// change round number every 2 dones
			roundNum += 1;
			round.setText("Round " + roundNum);
			
			// reset the die
			btnRoll.setText("Roll 2 die");
			
			
			// End the game after 3 rounds each
			
			if (roundNum > 6) {
				int winner = 0;
	
				// Determine who won
				
				if (p1Score > p2Score) {
					winner = 2;
				}
				
				else if (p2Score > p1Score) {
					winner = 1;
				}
				
				// tie
				else {
					winner = 3;
				}
				
				// create new scene for win message
				VBox root2 = new VBox(10);
				root2.setAlignment(Pos.CENTER);
				
				Label winMsg = new Label("");
				
				// if there's a tie
				if (winner == 3) {
					winMsg.setText("It's a tie!");
				}
				
				// Display the player that won
				else {
					winMsg.setText("Player " + winner + " Wins!");
				}
				
				Font bigFont = new Font("Arial", 40);
				winMsg.setFont(bigFont);
				
				root2.getChildren().add(winMsg);
				
				Scene endScene = new Scene(root2, 500, 500);
				stage.setScene(endScene);
				stage.show();
			}
			
			
		});

		btnBox.setAlignment(Pos.CENTER);
		root.getChildren().add(round);
		root.getChildren().addAll(p1, p2);
		root.getChildren().add(btnBox);
		root.getChildren().add(btnRoll);
		root.getChildren().add(dieResult);
		root.getChildren().addAll(lockIn, done);
		root.getChildren().add(dieResultPossible);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();

	}

}
