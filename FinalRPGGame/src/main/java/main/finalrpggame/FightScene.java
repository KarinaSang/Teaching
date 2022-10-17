package main.finalrpggame;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.finalrpggame.model2d.Character2D;

import java.util.Objects;

public class FightScene {
    private Scene scene;
    private GraphicsContext gc;
    private Character2D player;

    public FightScene(Scene scene, GraphicsContext gc) {
        this.scene = scene;
        this.gc = gc;
        init();
        drawPlayer(gc);
    }

    private void init() {
        Image playerImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/link_character.png")));
        player = new Character2D(playerImage, "Link",
                playerImage.getWidth()*0.5, playerImage.getHeight()*0.5,
                20, 100);
    }

    public Character2D getPlayer(){
        return player;
    }

    public void drawPlayer(GraphicsContext gc) {
        gc.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }
}
