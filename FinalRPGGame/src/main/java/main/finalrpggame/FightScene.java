package main.finalrpggame;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import main.finalrpggame.model2d.Character2D;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FightScene {
    public final static int NUM_OF_MONSTERS = 5;
    private Scene scene;
    private GraphicsContext gc;
    private Character2D player;

    private List<Character2D> monsters;

    private int curNumOfMonsters;

    public FightScene(Scene scene, GraphicsContext gc) {
        this.scene = scene;
        this.gc = gc;
        init();
        drawPlayer(gc);
    }

    private void init() {
        Image playerImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/link_character.png")));
        player = new Character2D(playerImage, "Link",
                playerImage.getWidth()*0.2, playerImage.getHeight()*0.2,
                20, 100);

        Image goblinImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/goblin_character.png")));
        monsters = new ArrayList <Character2D> ();

        curNumOfMonsters = NUM_OF_MONSTERS;

        for (int i = 0; i < NUM_OF_MONSTERS; i++) {
            monsters.add(new Character2D(goblinImage, "Goblin" + (i+1),
                    goblinImage.getWidth()*0.2, goblinImage.getHeight()*0.2,
                    (int)(Math.random()*780), (int)(Math.random()*280)));
        }
    }

    public Character2D getPlayer(){
        return player;
    }

    public void render(GraphicsContext gc, TextArea output) {
        Character2D monster = removeCollider();

        if (monster != null) {
            output.appendText(monster + " is killed!\n");
            if (curNumOfMonsters == 0) {
                output.appendText("All monsters are killed! Good job!\n");
            }
        }

        drawPlayer(gc);
        drawMonsters(gc);
    }

    private void drawPlayer(GraphicsContext gc) {
        gc.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }

    private void drawMonsters(GraphicsContext gc) {
        for (int i = 0; i < curNumOfMonsters; i++) {
            Character2D monster = monsters.get(i);
            gc.drawImage(monster.getImage(), monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
        }
    }

    public Character2D removeCollider() {
        int result = getCollider();

        if (result != -1) {
            curNumOfMonsters--;
            return monsters.remove(result);
        }

        return null;
    }


    private int getCollider() {
        for (int i = 0; i < curNumOfMonsters; i++) {
            Character2D monster = monsters.get(i);
            boolean checkX = player.getX() >= monster.getX() && player.getX() <= monster.getX() + monster.getWidth();
            boolean checkY = player.getY() <= monster.getY() && player.getY() >= monster.getY() - monster.getHeight();

            if (checkX && checkY) {
                System.out.println(monster);
                System.out.println(player);
                return i;
            }
        }

        return -1;
    }
}
