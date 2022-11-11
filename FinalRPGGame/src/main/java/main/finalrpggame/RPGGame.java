package main.finalrpggame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.finalrpggame.model2d.Character2D;

import java.util.Objects;


public class RPGGame extends Application {
    private TextArea output;
    private Button restartButton;
    private Label playerHPLabel;
    private int numOfPotions;
    private Label potionLabel;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    private FightScene fightScene;

    private Parent createContent() {
        // initialize variables
        output = new TextArea();
        numOfPotions = 5;

        restartButton = new Button("RESTART");
        playerHPLabel = new Label("HP: 100");
        potionLabel = new Label(String.valueOf(numOfPotions));

        output.setPrefHeight(450);
        restartButton.setFont(Font.font("Arial", 26));
        playerHPLabel.setFont(Font.font("Arial", 26));
        potionLabel.setFont(Font.font("Arial", 20));
        output.setFont(Font.font("Arial", 26));

        VBox root = new VBox(10);
        root.setPrefSize(800, 600);

        Image potionImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/main/finalrpggame/img/potion.png")));
        ImageView potionImageView = new ImageView(potionImage);
        potionImageView.setFitHeight(40);
        potionImageView.setFitWidth(30);
        StackPane potionPane = new StackPane();
        potionPane.getChildren().add(potionImageView);
        potionPane.getChildren().add(potionLabel);


        GridPane toolPane = new GridPane();
        toolPane.add(playerHPLabel, 1, 0);
        toolPane.add(potionPane, 2, 0);
        toolPane.add(restartButton, 3, 0);
        toolPane.setHgap(30);

        restartButton.setOnAction(e -> restart());

        canvas = new Canvas(800, 300);
        gc = canvas.getGraphicsContext2D();
        fightScene = new FightScene(canvas, gc);

        root.setOnKeyPressed(e -> {
            Character2D player2D = fightScene.getPlayer();

            if (player2D.getInfo().getHp() <= 0) {
                return;
            }

            // moving player
            if (e.getCode() == KeyCode.W) {
                player2D.setY(player2D.getY()-10);
            }
            else if (e.getCode() == KeyCode.S) {
                player2D.setY(player2D.getY()+10);
            }
            else if (e.getCode() == KeyCode.A) {
                player2D.setX(player2D.getX()-10);
            }
            else if (e.getCode() == KeyCode.D) {
                player2D.setX(player2D.getX()+10);
            }


            // attacking monsters
            if (fightScene.getCollider() != -1) {
                if (e.getCode() == KeyCode.J) {
                    makeMove(Action.ATTACK);
                }
                else if (e.getCode() == KeyCode.K) {
                    makeMove(Action.CHARGE);
                }
                else if (e.getCode() == KeyCode.L) {
                    makeMove(Action.BLOCK);
                }
            }

            // consuming potion
            if (e.getCode() == KeyCode.P) {
                int hp = player2D.getInfo().getHp();

                if (hp != 100) {
                    numOfPotions--;
                    player2D.getInfo().setHp(Math.min(hp+10, 100));
                    int newHp = player2D.getInfo().getHp();
                    playerHPLabel.setText("HP: " + newHp);
                    output.appendText("Player drinks one potion and restores hp to " + newHp + "\n");
                    potionLabel.setText(String.valueOf(numOfPotions));
                }
            }

            fightScene.render(gc, output);
        });


        root.getChildren().addAll(toolPane, canvas, output);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane mainMenu = new Pane();
        Button startButton = new Button("START GAME");
        startButton.setFont(Font.font("Arial", 26));
        mainMenu.getChildren().add(startButton);
        scene = new Scene(mainMenu, 800, 600);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("RPG GAME");

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                fightScene.render(gc, output);
            }
        };

        startButton.setOnAction(e -> {
            stage.getScene().setRoot(createContent());
            gameLoop.start();
        });


    }

    private void restart() {
        output.clear();
        fightScene = new FightScene(canvas, gc);
        playerHPLabel.setText("HP: 100");
        numOfPotions = 5;
        potionLabel.setText(String.valueOf(numOfPotions));
    }


    private void makeMove(Action userAction) {
        Action aiAction = makeAIMove();
        Character ai = fightScene.getSelectedMonster().getInfo();
        Character player = fightScene.getPlayer().getInfo();

        ActionResult result = userAction.checkAgainst(aiAction);

        if (result == ActionResult.DRAW) {

            output.appendText("DRAW\n");

        } else if (result == ActionResult.WIN) {

            int dmg = player.calcDamage(userAction);

            ai.setHp(ai.getHp() - dmg);
            output.appendText("Player deals " + dmg + " to Goblin \n");
            updateInfo();
        } else { // LOSE

            int dmg = ai.calcDamage(aiAction);

            player.setHp(player.getHp() - dmg);
            output.appendText("Goblin deals " + dmg + " to player \n");
            updateInfo();

            // if player loses all hp
            if (player.getHp() < 0) {
                output.appendText("Game over. Monsters wins!");
            }
        }

        playerHPLabel.setText("HP: " + player.getHp());
    }

    private void updateInfo() {
        output.appendText("Player: " + fightScene.getPlayer().getInfo() + ", " +  fightScene.getSelectedMonster().getName() + ": " + fightScene.getSelectedMonster().getInfo() + "\n");
    }

    private Action makeAIMove() {
        return Action.values()[(int) (Math.random() * Action.values().length)];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
