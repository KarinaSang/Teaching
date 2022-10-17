package main.finalrpggame.model2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Character2D extends GameObject2D {
    Image characterImage;

    public Character2D(Image characterImage, String name, double width, double height, double x, double y) {
        super(name, width, height, x, y);
        this.characterImage = characterImage;
    }

    public Image getImage(){
        return characterImage;
    }

}

