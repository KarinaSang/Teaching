package game.components;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class BulletComponent extends Component {
    private Entity tower;
    private Entity target;

    public BulletComponent(Entity tower, Entity target) {
        this.tower = tower;
        this.target = target;
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.distanceBBox(target) < 200 * tpf) {
            entity.removeFromWorld();
            return;
        }

        entity.translateTowards(target.getCenter(), 200 * tpf);
    }
}
