package main.finalrpggame.model2d;

import javafx.scene.image.Image;
import main.finalrpggame.characters.Character;
import main.finalrpggame.Direction;

public class Character2D extends GameObject2D {
    private Image characterImage;
    private Direction dir;

    private Character info;

    public Character2D(Image characterImage, double width, double height, double x, double y, Character info) {
        super(width, height, x, y);
        this.characterImage = characterImage;
        dir = Direction.getNewDirection();
        this.info = info;
    }

    public Image getImage(){
        return characterImage;
    }

    @Override
    public String toString() {
        return info.getName() + " " + this.getX() + ", " + this.getY();
    }

    public Direction getDirection() {
        return dir;
    }

    public void setDirection(Direction direction) {
        this.dir = direction;
    }

    public void moveLeft() {
        this.setX(this.getX() - info.getVelocity());
    }


    public void moveRight() {
        this.setX(this.getX() + info.getVelocity());
    }

    public void moveUp() {
        this.setY(this.getY() - info.getVelocity());
    }

    public void moveDown() {
        this.setY(this.getY() + info.getVelocity());
    }

    public Character getInfo() {
        return info;
    }

    public void setInfo(Character info) {
        this.info = info;
    }

}

