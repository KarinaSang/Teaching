package ui;

import com.almasb.fxgl.entity.Entity;
import data.TowerData;
import javafx.scene.layout.HBox;

import java.util.List;

public class TowerSelectionBox extends HBox {
    public TowerSelectionBox(List<TowerData> towerDataList) {
        setSpacing(5);

        towerDataList.forEach(data -> {
            var icon = new TowerIcon(data);
            icon.setOnMouseClicked(e -> {
                System.out.println("Clicked on " + data.name());
            });

            getChildren().add(icon);
        });
    }


}
