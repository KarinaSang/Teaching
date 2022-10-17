module main.finalrpggame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens main.finalrpggame to javafx.fxml;
    exports main.finalrpggame;
}