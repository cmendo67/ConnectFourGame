/*
    Name:Carlos Mendoza
    Description:Creating a connect Four Game.
 */
package ConnectFourGame;


import ConnectFourGame.BoardDisplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//The Purpose of this class was to seperate my game menu gui code with my board display gui code.
//This class displays my game Menu to start my game.

public class GameMenu extends BoardDisplay {

    public GameMenu() {
        //BorderPane has access to my csss file to get my images for my background game menu.
        this.getStylesheets().add("GameDriver/Style/styles.css");
        this.getStyleClass().add("winner");

        //create a button for my first option(play)
        Button playButton = new Button("PLAY");
        playButton.getStyleClass().add("quitbuttoncolor");

        //create a second button for second option(quit)
        Button quitButton = new Button("QUIT");
        quitButton.getStyleClass().add("quitbuttoncolor");

        //Insert my buttons in a vbox
        VBox playBox = new VBox(10);
        playBox.getChildren().addAll(playButton, quitButton);
        playBox.setAlignment(Pos.CENTER);

        //use set on action when you click on play
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //when you click on play, game should pop out and show you a grid of circles with 6 rows and 7 columns
                //I have to instantiate BoardDisplay in order to show my game
                    BoardDisplay carlosGame = new BoardDisplay();
                    // I have to add BoardDisplay in a scene in order for it to show in a window
                    Scene scene = new Scene(carlosGame, 1000, 1000);
                    Stage stage = new Stage();
                    stage.setTitle("Carlos Game"); // Set the stage title
                    stage.setScene(scene); // Place the scene in the stage
                    stage.show(); //


            }
        });
        //use set on action when you click on quit
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });



        //Create Title
        Text title = new Text("");
        title.getStyleClass().add("titleText");

        HBox gameTitle = new HBox(10);
        gameTitle.getStyleClass().add("title");
        gameTitle.getChildren().add(title);
        gameTitle.setAlignment(Pos.CENTER);

        //Add game title and my buttons innto border pane(this)
        this.setTop(gameTitle);
        this.setCenter(playBox);
    }
}