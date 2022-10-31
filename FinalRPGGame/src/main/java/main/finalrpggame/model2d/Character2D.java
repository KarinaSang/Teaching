package main.finalrpggame.model2d;

import javafx.scene.image.Image;
import main.finalrpggame.Character;
import main.finalrpggame.Direction;

public class Character2D extends GameObject2D {
    private Image characterImage;
    private double velocity;
    private Direction dir;

    private Character info;

    public Character2D(Image characterImage, String name, double width, double height, double x, double y, Character info) {
        super(name, width, height, x, y);
        this.characterImage = characterImage;
        this.velocity = 1.0;
        dir = Direction.getNewDirection();
        this.info = info;
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

    public Direction getDirection() {
        return dir;
    }

    public void setDirection(Direction direction) {
        this.dir = direction;
    }

    public void moveLeft() {
        this.setX(this.getX() - velocity);
    }


    public void moveRight() {
        this.setX(this.getX() + velocity);
    }

    public void moveUp() {
        this.setY(this.getY() - velocity);
    }

    public void moveDown() {
        this.setY(this.getY() + velocity);
    }

    public Character getInfo() {
        return info;
    }

    public void setInfo(Character info) {
        this.info = info;
    }

}

