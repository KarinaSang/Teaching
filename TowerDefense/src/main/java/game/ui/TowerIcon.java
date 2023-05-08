package game.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import game.data.TowerData;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TowerIcon extends VBox {
    private Texture texture;
    private TowerData data;

    public TowerIcon(TowerData data) {
        this.data = data;
        var bg = new Circle(35, 35, 35);
        bg.setStroke(Color.WHITE);
        bg.setStrokeWidth(2.5);

        var text = FXGL.getUIFactoryService().newText(data.cost() + "");
        text.setStroke(Color.BLACK);

        texture = FXGL.texture(data.imageName());

        var stackPane = new StackPane(bg, texture);

        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(stackPane, text);

    }
}
