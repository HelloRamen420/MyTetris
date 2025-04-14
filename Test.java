import java.awt.Color;
import java.awt.font.GraphicAttribute;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.Pane;

public class Test extends Application {
    GraphicsContext gra;

    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Canvas cvs = new Canvas(500, 500);
        gra = cvs.getGraphicsContext2D();
        pane.getChildren().add(cvs);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();

        draw();
    }

    public void draw() {
        gra.setFill(javafx.scene.paint.Color.RED);
        gra.fillRect(125, 125, 250, 250);
    }

    public static void main(String[] args) {
        Random rm = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(rm.nextInt(7) + 1);
        }
    }
}
