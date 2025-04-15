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
        Boolean[] minoBool = new Boolean[7];
        for (int i = 0; i < 7; i++) {
            minoBool[i] = false;
        }
        Boolean roopNextMinoAdd = false;
        int keep, count;
        count = 0;
        System.out.println(minoBool[2]);
        while (!roopNextMinoAdd) {
            keep = rm.nextInt(7) + 1;

            if (!minoBool[keep - 1]) {
                System.out.println(keep);
                minoBool[keep - 1] = true;
            }

            for (int j = 0; j < 7; j++) {
                if (minoBool[j]) {
                    count++;
                }
            }
            if (count == 7) {
                count = 0;
                break;
            }
        }
    }
}
