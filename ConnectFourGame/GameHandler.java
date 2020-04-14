/*
    Name:Carlos Mendoza
    Description:Creating a connect Four Game.
 */
package ConnectFourGame;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//The purpose of this class was to put all my validation in a single class.
//For this class I created three ethods validates my game which are horizontal, vertical, and diagonal.
public class GameHandler {

    //This method allows my discs(chips) to stack up in the game
    //This method also allows the discs(chips) to alternate from player to player 2.
    //I made this method static because I can just call my method into BoardDisplay.
    public static int placeDisc(int[][] placeDisc, int column) {

        int v = 0;

        for (int row = 0; row < placeDisc.length; row++) {

//            System.out.println("row:"+ row + "column:" + column);
            if (row < placeDisc.length - 1) {

                if (placeDisc[row + 1][column] == 1 || placeDisc[row + 1][column] == 2) {

                    v = row;

                    break;
                }

            } else if (row == placeDisc.length - 1 && placeDisc[row][column] == 0) {

                v = row;
            }
        }
        return v;
    }

    //This method validates my game horizontally and I also made my method static because i just want
//    to call the method in BoardDisplay.
    public static int horizontal(int row, int column, int[][] placeDisc, int playerTurn) {

        int v = 0;
        int c = column;
        int r = row;

        for (int i = column; i < placeDisc.length; i++) {
            if (placeDisc[r][i] == playerTurn) {
                v = v + 1;
            }
            if (v == 4) {
                break;
            }
        }

        if (v != 4) {
            v = 0;
            for (int i = column; i >= 0; i--) {
                if (placeDisc[r][i] == playerTurn) {
                    v = v + 1;
                }
                if (v == 4) {
                    break;
                }

            }

            if (v != 4) {
                v = 0;
                if (column >= 1 && column <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }

            if (v != 4) {
                v = 0;
                if (column >= 2 && column <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }

            if (v != 4) {
                v = 0;
                if (column >= 2 && column <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }

            if (v != 4) {
                v = 0;
                if (column >= 2 && column <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }

            if (v != 4) {
                v = 0;
                if (column >= 1 && column <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }
//        When the player has 4 discs(chips) in a row he wins.This validation is what makes my pop out display.
        if(v == 4){
            //java Fx
            if(placeDisc[r][c] == playerTurn) {
                //java Fx
                BorderPane winner = new BorderPane();
                winner.getStylesheets().add("ConnectFourGame/Style/styles.css");
                winner.getStyleClass().add("winner");

                Text title = new Text("");
                title.getStyleClass().add("titleText");

                HBox gameTitle = new HBox(10);
                gameTitle.getStyleClass().add("title");
                gameTitle.getChildren().add(title);
                gameTitle.setAlignment(Pos.CENTER);

                Text text = new Text();
                text.setX(10.0f);
                text.setY(10.0f);
                text.setCache(true);
                text.setText("PLAYER" + playerTurn + "wins!");
                text.setFill(Color.BLUE);
                text.setFont(Font.font(null, FontWeight.BOLD, 30));

                Reflection reflect = new Reflection();
                reflect.setFraction(0.7f);
                text.setEffect(reflect);
                text.setTranslateY(400);

                VBox gameWinner = new VBox(10);
                gameWinner.getChildren().add(text);
                gameWinner.setAlignment(Pos.CENTER);

                Button  exitButton = new Button("EXIT");
                exitButton.getStyleClass().add("quitbuttoncolor");

                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.exit(0);
                    }
                });

                VBox exitBox = new VBox(10);
                exitBox.getChildren().addAll(exitButton);
                exitBox.setAlignment(Pos.CENTER);

                winner.setCenter(gameTitle);
                winner.setTop(gameWinner);
                winner.setBottom(exitBox);

                Scene scene = new Scene(winner, 500, 600);
                Stage stage = new Stage();
                stage.setTitle("Carlos Game"); // Set the stage title
                stage.setScene(scene); // Place the scene in the stage
                stage.show(); //
                System.out.println("Winner");
            }
            }
        return v;
    }
    //This method validates my game vertically and I also made my method static because i just want
//    to call the method in BoardDisplay.
    public static int vertical(int row, int column, int[][] placeDisc, int playerTurn){
        int v = 0;
        int c = column;
        int r = row;

        for (int i = row; i < placeDisc.length; i++) {
            if (placeDisc[i][column] == playerTurn) {
                v = v + 1;
            }
            else if (v == 4) {
                break;
            }

        }
//        When the player has 4 discs(chips) in a row he wins.This validation is what makes my pop out display.
        if(v == 4){
                //java Fx
                BorderPane winner = new BorderPane();
                winner.getStylesheets().add("ConnectFourGame/Style/styles.css");
                winner.getStyleClass().add("winner");

                Text title = new Text("");
                title.getStyleClass().add("titleText");

                HBox gameTitle = new HBox(10);
                gameTitle.getStyleClass().add("title");
                gameTitle.getChildren().add(title);
                gameTitle.setAlignment(Pos.CENTER);

                Text text = new Text();
                text.setX(10.0f);
                text.setY(10.0f);
                text.setCache(true);
                text.setText("PLAYER" + playerTurn + "wins!");
                text.setFill(Color.BLUE);
                text.setFont(Font.font(null, FontWeight.BOLD, 30));

                Reflection reflect = new Reflection();
                reflect.setFraction(0.7f);
                text.setEffect(reflect);
                text.setTranslateY(400);

                VBox gameWinner = new VBox(10);
                gameWinner.getChildren().add(text);
                gameWinner.setAlignment(Pos.CENTER);

                Button  exitButton = new Button("EXIT");
                exitButton.getStyleClass().add("quitbuttoncolor");

                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.exit(0);
                    }
                });

                VBox exitBox = new VBox(10);
                exitBox.getChildren().addAll(exitButton);
                exitBox.setAlignment(Pos.CENTER);

                winner.setCenter(gameTitle);
                winner.setTop(gameWinner);
                winner.setBottom(exitBox);

                Scene scene = new Scene(winner, 500, 600);
                Stage stage = new Stage();
                stage.setTitle("Carlos Game"); // Set the stage title
                stage.setScene(scene); // Place the scene in the stage
                stage.show(); //

            System.out.println("WINNER");
        }
        return v;
    }
    //This method validates my game diagonal and I also made my method static because i just want
//    to call the method in BoardDisplay.
    public static int checkDiagonals(int row, int col, int[][] placeDisc, int playerTurn) {
        int v = 0;

        int r = row;
        int c = col;

        for (int i = c; i < placeDisc[0].length; i++) {
            if (r <= 5) {
                if (placeDisc[r][i] == playerTurn) {
                    v = v + 1;
                }
                else if (v == 4) {
                    break;
                }
            }
            r++;
        }

        if (v != 4) {
            r = row;
            c = col;
            v = 0;

           for (int i = c; i >= 0; i--) {
               if (r < placeDisc.length) {
                   if (placeDisc[r][i] == playerTurn) {
                       v = v + 1;
                   }
                   else if (v == 4) {
                       break;
                   }
                   r++;
               }

           }
        }

        if (v != 4) {
            r = row;
            c = col;
            v = 0;

            for (int i = c; i < placeDisc[0].length; i++) {
                if (r >= 0) {
                    if (placeDisc[r][i] == playerTurn) {
                        v = v + 1;
                    }
                    else if (v == 4) {
                        break;
                    }

                    r--;
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            for (int i = c; i >= 0; i--) {
                if (r >= 0) {
                    if (placeDisc[r][i] == playerTurn) {
                        v = v + 1;
                    }
                    else if (v == 4) {
                        break;
                    }

                    r--;
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 1 && r <= 3) {
                if (c  >= 1 && c <= 4) {
                            if (placeDisc[r][c] == playerTurn) {
                                v = v + 1;
                    }
                    if (placeDisc[r - 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 2][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 1 && r <= 3) {
                if (c  >= 2 && c <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 2][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 2 && r <= 4) {
                if (c  >= 1 && c <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 2][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 2 && r <= 4) {
                if (c  >= 2 && c <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 2][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 2 && r <= 4) {
                if (c  >= 2 && c <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 2][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 2 && r <= 4) {
                if (c  >= 1 && c <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 2][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 1 && r <= 3) {
                if (c  >= 2 && c <= 5) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 2][c - 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }

        if (v != 4) {
            v = 0;
            r = row;
            c = col;

            if (r >= 1 && r <= 3) {
                if (c  >= 1 && c <= 4) {
                    if (placeDisc[r][c] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 1][c + 1] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r + 2][c + 2] == playerTurn) {
                        v = v + 1;
                    }
                    if (placeDisc[r - 1][c - 1] == playerTurn) {
                        v = v + 1;
                    }
                }
            }
        }
        //When the player has 4 discs(chips) in a row he wins.This validation is what makes my pop out display.
        if (v == 4) {
                //java Fx
                BorderPane winner = new BorderPane();
                winner.getStylesheets().add("ConnectFourGame/Style/styles.css");
                winner.getStyleClass().add("winner");

                Text title = new Text("");
                title.getStyleClass().add("titleText");

                HBox gameTitle = new HBox(10);
                gameTitle.getStyleClass().add("title");
                gameTitle.getChildren().add(title);
                gameTitle.setAlignment(Pos.CENTER);

                Text text = new Text();
                text.setX(10.0f);
                text.setY(10.0f);
                text.setCache(true);
                text.setText("PLAYER" + playerTurn + "wins!");
                text.setFill(Color.BLUE);
                text.setFont(Font.font(null, FontWeight.BOLD, 30));

                Reflection reflect = new Reflection();
                reflect.setFraction(0.7f);
                text.setEffect(reflect);
                text.setTranslateY(400);

                VBox gameWinner = new VBox(10);
                gameWinner.getChildren().add(text);
                gameWinner.setAlignment(Pos.CENTER);

                Button  exitButton = new Button("EXIT");
                exitButton.getStyleClass().add("quitbuttoncolor");

                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.exit(0);
                    }
                });

                VBox exitBox = new VBox(10);
                exitBox.getChildren().addAll(exitButton);
                exitBox.setAlignment(Pos.CENTER);

                winner.setCenter(gameTitle);
                winner.setTop(gameWinner);
                winner.setBottom(exitBox);

                Scene scene = new Scene(winner, 500, 600);
                Stage stage = new Stage();
                stage.setTitle("Carlos Game"); // Set the stage title
                stage.setScene(scene); // Place the scene in the stage
                stage.show(); //
                System.out.println("Winner");

        }
        return v;
    }
}