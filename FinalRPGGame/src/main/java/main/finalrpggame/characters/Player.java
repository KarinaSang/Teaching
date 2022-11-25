package main.finalrpggame.characters;

import javafx.scene.image.Image;

import java.util.Objects;

public class Player extends Character{
    boolean arrowOn;
    int arrowTimer;

    public Player(int hp, int attackPower, int chargePower, int blockPower, String name) {
        super(hp, attackPower, chargePower, blockPower, name);
        arrowOn = false;
        arrowTimer = 0;
    }

    public void resetArrow() {
        arrowOn = false;
        arrowTimer = 0;
    }

    public boolean getArrow() {
        return arrowOn;
    }

    public int getArrowTimer() {
        return arrowTimer;
    }

    public void increaseArrowTimer() {
        arrowTimer++;
    }

    @Override
    public String castAbility() {
        arrowOn = true;
        return "Firing an arrow\n";
    }
}
