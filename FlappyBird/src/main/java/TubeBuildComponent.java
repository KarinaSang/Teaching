import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.shape.Rectangle;

public class TubeBuildComponent extends Component {
    private double lastX = 1000;

    @Override
    public void onUpdate(double tpf) {
        if (lastX - entity.getX() < FXGL.getAppWidth()) {
            buildTubes();
        }
    }

    private Rectangle newTube(double width, double height) {
        Rectangle tube = new Rectangle(width, height);
        tube.setArcWidth(25);
        tube.setArcHeight(25);
        return tube;
    }

    private void buildTubes() {
        double height = FXGL.getAppHeight();
        double distance = height/2;

        for (int i = 1; i <= 10; i++) {
            double topHeight = Math.random() * distance;
            double curX = lastX + i*500;

            // top tube
            FXGL.entityBuilder()
                    .at(curX, -25)
                    .type(EntityType.TUBE)
                    .viewWithBBox(newTube(50, topHeight))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();

            // bot tube
            FXGL.entityBuilder()
                    .at(curX, topHeight + distance + 25)
                    .type(EntityType.TUBE)
                    .viewWithBBox(newTube(50, distance-topHeight))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();

        }

        lastX += 10*500;
    }
}
