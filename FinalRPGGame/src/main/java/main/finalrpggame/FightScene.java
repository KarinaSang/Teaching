package main.finalrpggame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import main.finalrpggame.characters.Character;
import main.finalrpggame.characters.Goblin;
import main.finalrpggame.characters.Player;
import main.finalrpggame.characters.Vampire;
import main.finalrpggame.model2d.Character2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FightScene {
    public final static int NUM_OF_MONSTERS = 5;
    private Canvas canvas;
    private GraphicsContext gc;
    private Character2D player;

    private List<Character2D> monsters;
    private Character2D selectedMonster;

    private int curNumOfMonsters;
    private int numOfPotions;

    private int loopTimer;
    private int curLevel;

    public FightScene(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
        init();
        drawPlayer(gc);
    }

    private void init() {
        curLevel = 1;
        numOfPotions = 5;
        Character playerInfo = new Player(100, 15, 30, 5, "Link");

        Image playerImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/link_character.png")));
        player = new Character2D(playerImage,
                playerImage.getWidth()*0.2, playerImage.getHeight()*0.2,
                20, 100, playerInfo);

        Image goblinImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/goblin_character.png")));
        monsters = new ArrayList <Character2D> ();

        curNumOfMonsters = NUM_OF_MONSTERS;

        for (int i = 0; i < NUM_OF_MONSTERS; i++) {
            Character aiInfo = new Goblin(50, 5, 10, 8, "Goblin" + (i+1));
            monsters.add(new Character2D(goblinImage,
                    goblinImage.getWidth()*0.2, goblinImage.getHeight()*0.2,
                    (int)(Math.random()*780), (int)(Math.random()*280), aiInfo));
        }

        loopTimer = 0;
    }

    private void level2() {
        numOfPotions = 5;
        Character playerInfo = new Player(100, 15, 30, 5, "Link");

        Image playerImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/link_character.png")));
        player = new Character2D(playerImage,
                playerImage.getWidth()*0.2, playerImage.getHeight()*0.2,
                20, 100, playerInfo);

        Image vampireImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/vampire.png")));
        monsters = new ArrayList <Character2D> ();

        curNumOfMonsters = NUM_OF_MONSTERS;

        for (int i = 0; i < NUM_OF_MONSTERS; i++) {
            Character aiInfo = new Vampire(50, 5, 10, 8, "Vampire" + (i+1));
            monsters.add(new Character2D(vampireImage,
                    vampireImage.getWidth()*0.2, vampireImage.getHeight()*0.2,
                    (int)(Math.random()*780), (int)(Math.random()*280), aiInfo));
        }

        loopTimer = 0;
    }

    public int getNumberOfPotions() {
        return numOfPotions;
    }

    public void consumePotion() {
        numOfPotions--;
    }

    public Character2D getPlayer(){
        return player;
    }

    public Character2D getSelectedMonster() {
        return selectedMonster;
    }

    public void render(GraphicsContext gc, TextArea output) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (player.getInfo().getHp() <= 0) {
            return;
        }

        Character2D monster = removeCollider();

        if (monster != null) {
            output.appendText(monster + " is killed!\n");
            if (curNumOfMonsters == 0) {
                output.appendText("All monsters are killed! Good job!\n");
                curLevel += 1;

                if (curLevel == 2) {
                    level2();
                }
            }
        }

        drawPlayer(gc);
        drawMonsters(gc);
    }

    private void drawPlayer(GraphicsContext gc) {
        gc.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }

    private void drawMonsters(GraphicsContext gc) {
        loopTimer++;
        if (loopTimer == 100) {
            loopTimer = 0;
            monsters.forEach(monster -> monster.setDirection(Direction.getNewDirection()));
        }

        for (int i = 0; i < curNumOfMonsters; i++) {
            Character2D monster = monsters.get(i);

            switch(monster.getDirection()) {
                case LEFT:
                    monster.moveLeft();
                    break;
                case RIGHT:
                    monster.moveRight();
                    break;
                case UP:
                    monster.moveUp();
                    break;
                case DOWN:
                    monster.moveDown();
                    break;
            }

            if (monster.getY() < 0) {
                monster.setDirection(Direction.DOWN);
            }
            else if (monster.getY() > canvas.getHeight()-50) {
                monster.setDirection(Direction.UP);
            }
            else if (monster.getX() < 0) {
                monster.setDirection(Direction.RIGHT);
            }
            else if (monster.getX() > canvas.getWidth()-50) {
                monster.setDirection(Direction.LEFT);
            }

            gc.drawImage(monster.getImage(), monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
        }
    }

    public Character2D removeCollider() {
        int result = getCollider();

        if (result != -1) {
            selectedMonster = monsters.get(result);

            if (selectedMonster.getInfo().getHp() <= 0) {
                curNumOfMonsters--;
                return monsters.remove(result);
            }
        }

        return null;
    }


    public int getCollider() {
        for (int i = 0; i < curNumOfMonsters; i++) {
            Character2D monster = monsters.get(i);
            boolean checkX = player.getX() >= monster.getX()-20 && player.getX() <= monster.getX() + monster.getWidth()+20;
            boolean checkY = player.getY() <= monster.getY()+20 && player.getY() >= monster.getY() - monster.getHeight()-20;

            if (checkX && checkY) {
                return i;
            }
        }

        return -1;
    }


}
