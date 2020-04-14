/*
    Name:Carlos Mendoza
    Description:Creating a connect Four Game.
 */
package ConnectFourGame;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.paint.Color.RED;


public  class BoardDisplay extends BorderPane {

    //There is 6 rows and 7 columns in connect Four.
    //Therefore I will make rows and columns constants.
    //The reason why is because I dont want to change the size of the grid because 6 rows
    //and 7 columns will be the only size in the game.

    //data Fields
    CirclePosition[][] c = new CirclePosition[6][7];
    int[][] playerTurn = new int[6][7];
    int currentPlayer = 1;

    public BoardDisplay() {

        this.getStylesheets().add("ConnectFourGame/Style/styles.css");
        this.getStyleClass().add("winner");

        //Create Title

        Text title = new Text("");
        title.getStyleClass().add("titleText");

        HBox gameTitle = new HBox(10);
        gameTitle.getStyleClass().add("title");
        gameTitle.setAlignment(Pos.CENTER);

        gameTitle.getChildren().add(title);

        this.setTop(gameTitle);

        //create GridPane for the Board of the game;
        GridPane gamePane = new GridPane();
        gamePane.setAlignment(Pos.CENTER);
        gamePane.getStylesheets().add("ConnectFourGame/Style/styles.css");

        //create 6 x 7 circles
        for (int row = 0; row < c.length; row++) {
            for (int column = 0; column < c[0].length; column++) {
                this.c[row][column] = new CirclePosition(row,column);
                gamePane.add(this.c[row][column], column, row);
                gamePane.setVgap(10);
                gamePane.setHgap(10);
                int finalRow = row;
                int finalColumn = column;
                this.c[row][column].setOnMouseClicked(e -> {
                    CirclePosition currentCircle = (CirclePosition)e.getSource();

                    int placeValue = GameHandler.placeDisc(this.playerTurn, currentCircle.getyPosition());


                    if(currentPlayer == 1) {

                        Circle circle1 = new Circle(15,15,15);
                        circle1.getStyleClass().add("discs");

                        Light.Distant circlelighting = new Light.Distant();
                        circlelighting.setAzimuth(100.0);
                        circlelighting.setElevation(100.0);

                        Lighting light= new Lighting();
                        light.setLight(circlelighting);
                        light.setSurfaceScale(5.0);
                        circle1.setEffect(light);

                        gamePane.add(circle1,currentCircle.getyPosition(), placeValue);
                        this.playerTurn[placeValue][currentCircle.getyPosition()] = 1;
                        //call my method that validates my game from GAMEHANDLER
                        GameHandler.horizontal(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        GameHandler.vertical(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        GameHandler.checkDiagonals(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        this.currentPlayer = 2;

                    }
                    else{
                        Circle circle2 = new Circle(15,15,15);
                        circle2.getStyleClass().add("discs2");

                        Light.Distant circlelighting = new Light.Distant();
                        circlelighting.setAzimuth(100.0);
                        circlelighting.setElevation(100.0);

                        Lighting light= new Lighting();
                        light.setLight(circlelighting);
                        light.setSurfaceScale(5.0);
                        circle2.setEffect(light);

                        gamePane.add(circle2, currentCircle.getyPosition(), placeValue);
                        this.playerTurn[placeValue][currentCircle.getyPosition()] = 2;
                        //call my method that validates my game from GAMEHANDLER
                        GameHandler.horizontal(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        GameHandler.vertical(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        GameHandler.checkDiagonals(placeValue, currentCircle.getyPosition(),this.playerTurn, this.currentPlayer);
                        this.currentPlayer = 1;
                    }

                });
            }
        }
        this.setCenter(gamePane);
    }

}
