/*
    Name:Carlos Mendoza
    Description:Creating a connect Four Game.
 */

package ConnectFourGame;

import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.Circle;


//The reason why i want to extend CIRCLE is because in order for me to validate the postion of each circle
//I must be able to access the x and y postion of the circle in the grid.If I extend CIRCLE then I will be able
//to access them.
//MAIN PURPOSE OF EXTENDING CIRCLE: Obataining the x and y postion of a Circle.
public class CirclePosition extends Circle {

    //data Fields:I need to know my x and y position
    private int xPosition;
    private int yPosition;

    //create default constructor
    //Empty constructor
    public CirclePosition(){}

    //This constructor allows me to create a circle and instantiate it with the x and y postions.
    public CirclePosition(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.setRadius(15);
        this.getStyleClass().add("circles");

        Light.Distant circlelighting = new Light.Distant();
        circlelighting.setAzimuth(100.0);
        circlelighting.setElevation(100.0);

        Lighting light= new Lighting();
        light.setLight(circlelighting);
        light.setSurfaceScale(5.0);
        this.setEffect(light);
    }

    //Getters
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    //setters
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}