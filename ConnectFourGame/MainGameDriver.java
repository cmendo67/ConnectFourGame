/*
    Name:Carlos Mendoza
    Description:Creating a connect Four Game.
 */
package ConnectFourGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class MainGameDriver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Instantiate game menu to run my game
        GameMenu connectFourGame = new GameMenu();

        //Add GameMenu into a scene in order for it to show my game
        Scene scene = new Scene(connectFourGame, 450, 500);
        Stage stage = new Stage();
        stage.setTitle("Carlos Game"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); //
    }


    public static void main(String[] args) {
        launch(args);

    }
}