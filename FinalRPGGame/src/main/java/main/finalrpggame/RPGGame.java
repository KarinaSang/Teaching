package main.finalrpggame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.finalrpggame.model2d.Character2D;


public class RPGGame extends Application {
    private Character player;
    private Character ai;
    private TextArea output;

    private Button attackButton;
    private Button chargeButton;
    private Button blockButton;
    private Button restartButton;

    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    private FightScene fightScene;

    private Parent createContent() {
        // initialize variables
        player = new Character(100, 15, 20, 5);
        ai = new Character(100, 10, 30, 8);
        output = new TextArea();

        attackButton = new Button("ATTACK");
        chargeButton = new Button("CHARGE");
        blockButton = new Button("BLOCK");
        restartButton = new Button("RESTART");

        VBox root = new VBox(10);
        root.setPrefSize(800, 600);

        GridPane toolPane = new GridPane();
        toolPane.add(attackButton, 0, 0);
        toolPane.add(chargeButton, 1, 0);
        toolPane.add(blockButton, 2, 0);
        toolPane.add(restartButton, 3, 0);
        toolPane.setHgap(30);

        attackButton.setOnAction(e -> makeMove(Action.ATTACK));
        chargeButton.setOnAction(e -> makeMove(Action.CHARGE));
        blockButton.setOnAction(e -> makeMove(Action.BLOCK));
        restartButton.setOnAction(e -> restart());

        output.setPrefHeight(450);
        attackButton.setFont(Font.font("Arial", 26));
        chargeButton.setFont(Font.font("Arial", 26));
        blockButton.setFont(Font.font("Arial", 26));
        restartButton.setFont(Font.font("Arial", 26));
        output.setFont(Font.font("Arial", 26));
        updateInfo();

        canvas = new Canvas(800, 300);
        gc = canvas.getGraphicsContext2D();
        fightScene = new FightScene(scene, gc);

        root.setOnKeyPressed(e -> {
            Character2D player2D = fightScene.getPlayer();
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

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            fightScene.render(gc, output);
        });


        root.getChildren().addAll(toolPane, canvas, output);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("RPG GAME");
    }

    private void disableButtons() {
        attackButton.setDisable(true);
        chargeButton.setDisable(true);
        blockButton.setDisable(true);
    }

    private void enableButtons() {
        attackButton.setDisable(false);
        chargeButton.setDisable(false);
        blockButton.setDisable(false);
    }


    private void restart() {
        enableButtons();
        output.clear();
        player.setHp(100);
        ai.setHp(100);
        updateInfo();
    }


    private void makeMove(Action userAction) {
        Action aiAction = makeAIMove();

        ActionResult result = userAction.checkAgainst(aiAction);

        if (result == ActionResult.DRAW) {

            output.appendText("DRAW\n");

        } else if (result == ActionResult.WIN) {

            int dmg = player.calcDamage(userAction);

            ai.setHp(ai.getHp() - dmg);
            output.appendText("Player deals " + dmg + " to AI \n");
            updateInfo();

            // if ai loses all hp
            if (ai.getHp() < 0) {
                output.appendText("Game over. Player wins!");
                disableButtons();
            }
        } else { // LOSE

            int dmg = ai.calcDamage(aiAction);

            player.setHp(player.getHp() - dmg);
            output.appendText("AI deals " + dmg + " to player \n");
            updateInfo();

            // if player loses all hp
            if (player.getHp() < 0) {
                output.appendText("Game over. AI wins!");
                disableButtons();
            }
        }
    }

    private void updateInfo() {
        output.appendText("Player: " + player + ", AI: " + ai + "\n");
    }

    private Action makeAIMove() {
        return Action.values()[(int) (Math.random() * Action.values().length)];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
