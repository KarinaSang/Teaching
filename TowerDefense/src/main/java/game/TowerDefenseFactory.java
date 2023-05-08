package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import game.data.TowerData;
import javafx.beans.binding.Bindings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

public class TowerDefenseFactory implements EntityFactory {
    @Spawns("Tower")
    public Entity newTower(SpawnData data) {
        TowerData towerData = data.get("towerData");

        return entityBuilder(data)
                .type(EntityType.TOWER)
                .viewWithBBox(towerData.imageName())
                .collidable()
                //.with(new TowerComponent(towerData))
                //.zIndex(Z_INDEX_TOWER)
                .build();
    }

    @Spawns("towerBase")
    public Entity newTowerBase(SpawnData data) {
        var rect = new Rectangle(64, 64, Color.GREEN);
        rect.setOpacity(0.25);

        var cell = FXGL.entityBuilder(data)
                .type(EntityType.TOWER_BASE)
                .viewWithBBox(rect)
                .onClick(e -> {
                    System.out.println("Generating a list of towers");

                    // let the place we are clicking on right now to spawn a tower,
                    // think of it as a cell
                    FXGL.<TowerDefenseApp>getAppCast().onCellClicked(e);
                })
                .build();

        rect.fillProperty().bind(
                Bindings.when(cell.getViewComponent().getParent().hoverProperty())
                        .then(Color.DARKGREEN)
                        .otherwise(Color.GREEN)
        );

        return cell;
    }

    @Spawns("Enemy")


    @Spawns("waypoints")
    public Entity newWayPoints(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.WAY)
                .build();
    }
}
