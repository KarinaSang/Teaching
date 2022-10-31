package main.finalrpggame.model2d;

import javafx.scene.shape.Rectangle;

public class GameObject2D extends Rectangle {
    private String name;

    public GameObject2D(String name, double width, double height, double x, double y) {
        this.name = name;
        setWidth(width);
        setHeight(height);
        setX(x);
        setY(y);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



}

