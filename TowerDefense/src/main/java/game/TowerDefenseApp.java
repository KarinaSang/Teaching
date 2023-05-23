package game;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import game.data.TowerData;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import game.ui.TowerSelectionBox;

import java.util.List;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGL.spawnWithScale;
import static game.data.Constants.*;

public class TowerDefenseApp extends GameApplication {
    private List<TowerData> towerDataList;
    private TowerSelectionBox towerSelectionBox;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(25 * 64);
        settings.setHeight(14 * 64);
        settings.setTitle("FXGL Tower Defense");
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put(MONEY, STARTING_MONEY);
        vars.put("tower_count", 0);
    }

    @Override
    protected void initGame() {
        loadTowerData();
        towerSelectionBox = new TowerSelectionBox(towerDataList);

        loadCurrentLevel();

        // spawn a dummy enemy for testing
        FXGL.spawn("Enemy", new Point2D(500, 500));
    }

    @Override
    protected void initUI() {
//        TowerIcon icon = new TowerIcon(towerDataList.get(0));
//        FXGL.addUINode(icon);
        FXGL.addUINode(towerSelectionBox);
        towerSelectionBox.setVisible(false);

        // money text
        var moneyText = getUIFactoryService().newText("", Color.WHITE, 32.0);
        moneyText.textProperty().bind(getip("money").asString());
        moneyText.setTranslateX(50);
        moneyText.setTranslateY(45);
        FXGL.addUINode(moneyText);

        // tower count text
        var towerCountText = getUIFactoryService().newText("", Color.WHITE, 32.0);
        towerCountText.textProperty().bind(getip("tower_count").asString());
        towerCountText.setTranslateX(150);
        towerCountText.setTranslateY(45);
        FXGL.addUINode(towerCountText);
    }


    public void onCellClicked(Entity cell) {
        // if we already have a tower on this tower base, ignore call
        if (cell.getProperties().exists("tower"))
            return;

        towerSelectionBox.setVisible(true);
//        var newCell = cell;
//        newCell.translate(64, 64);
        towerSelectionBox.setCell(cell);

        towerSelectionBox.setTranslateX(cell.getX()+50);
        towerSelectionBox.setTranslateY(cell.getY());
    }

    public void onTowerSelected(Entity cell, TowerData data) {
        // check money
        if (geti(MONEY) - data.cost() >= 0) {
            towerSelectionBox.setVisible(false);

            inc(MONEY, -data.cost());
            inc("tower_count", +1);

            var tower = spawnWithScale(
                    "Tower",
                    new SpawnData(cell.getPosition()).put("towerData", data),
                    Duration.seconds(0.85),
                    Interpolators.ELASTIC.EASE_OUT()
            );

            cell.setProperty("tower", tower);
        }
        else{
            FXGL.getDialogService().showMessageBox("Not enough money!");
        }
    }

    private void loadCurrentLevel() {
        FXGL.getGameWorld().addEntityFactory(new TowerDefenseFactory());
        FXGL.setLevelFromMap("tmx/" + "map1.tmx");

        FXGL.getGameWorld().getEntitiesFiltered(e -> e.isType("TiledMapLayer"))
                .forEach(e -> {
                    e.getViewComponent().addOnClickHandler(event -> {
                        towerSelectionBox.setVisible(false);
                    });
                });
    }

    private void loadTowerData() {
        List<String> towerNames = List.of(
                "tower1.json",
                "tower2.json",
                "tower3.json",
                "tower4.json",
                "tower5.json"
                //"tower6.json"
        );

        towerDataList = towerNames.stream()
                .map(name -> FXGL.getAssetLoader().loadJSON("towers/" + name, TowerData.class).get())
                .toList();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
