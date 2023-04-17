import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import data.TowerData;
import ui.TowerIcon;
import ui.TowerSelectionBox;

import java.util.ArrayList;
import java.util.List;

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
    protected void initGame() {
        loadTowerData();
        towerSelectionBox = new TowerSelectionBox(towerDataList);

        loadCurrentLevel();
    }

    @Override
    protected void initUI() {
//        TowerIcon icon = new TowerIcon(towerDataList.get(0));
//        FXGL.addUINode(icon);
        FXGL.addUINode(towerSelectionBox);
        towerSelectionBox.setVisible(false);

    }


    public void onCellClicked(Entity cell) {
        towerSelectionBox.setVisible(true);

        towerSelectionBox.setTranslateX(cell.getX()+50);
        towerSelectionBox.setTranslateY(cell.getY());
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
