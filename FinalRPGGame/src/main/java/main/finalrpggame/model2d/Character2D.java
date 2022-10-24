package main.finalrpggame.model2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Character2D extends GameObject2D {
    Image characterImage;
    double velocity;

    public Character2D(Image characterImage, String name, double width, double height, double x, double y) {
        super(name, width, height, x, y);
        this.characterImage = characterImage;
        this.velocity = 1.0;
    }

    public Image getImage(){
        return characterImage;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    @Override
    public String toString() {
        return this.getName() + " " + this.getX() + ", " + this.getY();
    }

}

