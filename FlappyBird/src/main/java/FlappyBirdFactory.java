import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FlappyBirdFactory implements EntityFactory {
    @Spawns("bird")
    public Entity newBird(SpawnData data) {
        Texture animatedBird = FXGL.texture("bird.png").toAnimatedTexture(2, Duration.seconds(0.5)).loop();
        BirdComponent birdComponent = new BirdComponent();

        return FXGL.entityBuilder()
                .at(100, 100)
                .type(EntityType.BIRD)
                .bbox(new HitBox(BoundingShape.box(70, 60)))
                .view(animatedBird)
                .with(new CollidableComponent(true))
                .with(birdComponent)
                .with(new TubeBuildComponent())
                .build();
    }


}
