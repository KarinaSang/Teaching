package game.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import game.TowerDefenseApp;
import game.data.TowerData;
import javafx.scene.layout.HBox;

import java.util.List;

public class TowerSelectionBox extends HBox {
    private Entity cell;
    public TowerSelectionBox(List<TowerData> towerDataList) {
        setSpacing(5);

        towerDataList.forEach(data -> {
            // icon is tower1, 2, 3, etc, for each iteration
            var icon = new TowerIcon(data);
            icon.setOnMouseClicked(e -> {
                System.out.println("Clicked on " + data.name());


                if (cell != null) {
                    FXGL.<TowerDefenseApp>getAppCast().onTowerSelected(cell, data);
                }

            });

            getChildren().add(icon);
        });
    }

    public void setCell(Entity cell) {
        this.cell = cell;
    }


}
