package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import game.EntityType;
import game.data.TowerData;
import javafx.geometry.Point2D;

public class TowerComponent extends Component {
    private TowerData data;
    private LocalTimer shootTimer;

    public TowerComponent(TowerData data) {
        this.data = data;
    }

    public int getDamage() {
        return data.attack();
    }

    @Override
    public void onUpdate(double tpf) {
        FXGL.getGameWorld().getClosestEntity(entity, e -> e.isType(EntityType.ENEMY))
                .ifPresent(nearestEnemy -> {
                    entity.rotateToVector(nearestEnemy.getPosition().subtract(entity.getPosition()));

                    // because of sprite rotation
                    entity.rotateBy(90);
                    shoot(nearestEnemy);
                    shootTimer.capture();
                });
    }

    @Override
    public void onAdded() {
        shootTimer = FXGL.newLocalTimer();
        shootTimer.capture();
    }

    private void shoot(Entity enemy) {
        Point2D position = entity.getPosition();
        Point2D direction = enemy.getPosition().subtract(position);

        var bullet = FXGL.spawn("Bullet", new SpawnData(position)
                .put("tower", entity)
                .put("target", enemy));

        bullet.rotateToVector(direction);

    }



}
