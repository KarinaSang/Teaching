import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.virtual.VirtualButton;
import javafx.animation.Interpolator;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Map;

public class FlappyBirdApp extends GameApplication {
    private BirdComponent birdComponent;
    private boolean newGame;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Flappy Bird");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("score", 0);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("jump") {
            @Override
            protected void onActionBegin() {
                birdComponent.jump();
            }
        }, KeyCode.SPACE, VirtualButton.UP);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new FlappyBirdFactory());

        Entity bird = FXGL.spawn("bird");
        birdComponent = bird.getComponent(BirdComponent.class);
        FXGL.getGameScene().getViewport().setBounds(0, 0, Integer.MAX_VALUE, FXGL.getAppHeight());
        FXGL.getGameScene().getViewport().bindToEntity(bird, FXGL.getAppWidth()/3, FXGL.getAppHeight()/2);
        FXGL.spawnWithScale(bird, Duration.seconds(0.86), Interpolators.BOUNCE.EASE_OUT());
        // FXGL.spawnWithScale(bird, Duration.seconds(0.86), Interpolators.SMOOTH.EASE_OUT());
    }

    @Override
    protected void initUI() {
        Group virtualButton = FXGL.getInput().createVirtualDpadView();
        FXGL.addUINode(virtualButton, 0, 625);

        Text scoreText = new Text("");
        scoreText.setFont(Font.font(68));
        scoreText.textProperty().bind(FXGL.getip("score").asString());
        FXGL.addUINode(scoreText, FXGL.getAppWidth()-200, 50);
    }

    @Override
    protected void initPhysics() {
        FXGL.onCollisionBegin(EntityType.BIRD, EntityType.TUBE, (bird, tube) -> {
            newGame = true;
        });
    }

    @Override
    protected void onUpdate(double tpf) {
        FXGL.inc("score", +1);

        if (FXGL.geti("score") == 1000) {
            gameOver();
        }

        if (newGame || birdComponent.getEntity().getBottomY() > FXGL.getAppHeight()) {
            newGame = false;
            FXGL.getGameController().startNewGame();
        }
    }

    private void gameOver() {
        FXGL.showMessage("Game over.", () -> {
            FXGL.getGameController().startNewGame();
        });
    }


    public static void main (String[] args) {
        launch(args);
    }
}
