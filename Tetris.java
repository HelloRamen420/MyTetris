
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tetris extends Application {
    final int STAGEWIDTH = 350;
    final int STAGEHEIGHT = 700;
    GraphicsContext gra;

    /*
     * フィールドの描写、ミノの座標を示す2次元配列です。
     *
     * 0:null
     * 1:赤
     * 2:緑
     * 3:青
     * 4:橙
     * 5:紫
     * 6:水
     * 7:黄
     *
     * で管理していきます。
     * 実際の描写のメソッドや座標管理のメソッドはまたどこかに。
     */
    private static int field[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 10
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 15
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } // 20

    };

    private Mino[] minos = { (new Mino(Mino.sM)), (new Mino(Mino.zM)), (new Mino(Mino.jM)), (new Mino(Mino.lM)),
            (new Mino(Mino.tM)), (new Mino(Mino.iM)), (new Mino(Mino.oM)) };
    private ArrayList<Mino> nextMinos;

    // 全体の流れを司るメソッドです。
    void flow() {

    }

    // 次に落ちてくるミノを決めるメソッドです。5巡足します。
    void nextMinoAdd() {
        Random rm = new Random();
        Boolean roopNextMinoAdd = false;
        int keep;
        for (int i = 0; i < 5; i++) {
            Boolean[] minoBool = new Boolean[7];
            while (roopNextMinoAdd) {
                keep = rm.nextInt(7) + 1;

                if (!minoBool[keep - 1]) {
                    nextMinos.add(minos[keep]);
                    minoBool[keep - 1] = true;
                }

                for (int j = 0; j < 7; j++) {
                    if (!minoBool[j]) {
                        continue;
                    }
                }
                roopNextMinoAdd = true;
            }
        }
    }

    // 描画をするメソッドです。難しいことは何もしていません。
    void depictionBranch() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                switch (field[i][j]) {
                    case 0:
                        depiction(new Color(0, 0, 0, 1), i, j);
                        break;
                    case 1:
                        depiction(new Color(1, 0, 0, 1), i, j);
                        break;
                    case 2:
                        depiction(new Color(0.102, 1, 0.102, 1), i, j);
                        break;
                    case 3:
                        depiction(new Color(0, 0.169, 1, 1), i, j);
                        break;
                    case 4:
                        depiction(new Color(1, 0.545, 0.101, 1), i, j);
                        break;
                    case 5:
                        depiction(new Color(0.561, 0.08, 0.8, 1), i, j);
                        break;
                    case 6:
                        depiction(new Color(0.4, 1, 1, 1), i, j);
                        break;
                    case 7:
                        depiction(new Color(1, 1, 0, 1), i, j);
                        break;
                    default:
                        System.out.println("今すぐデバッグしてね！");
                        break;
                }

            }
        }
    }

    void depiction(Color color, int Y, int X) {
        gra.setFill(color);
        gra.fillRect(X * (STAGEWIDTH / 10) + 2, Y * (STAGEWIDTH / 10) + 2,
                (STAGEWIDTH / 10) - 2, (STAGEWIDTH) / 10 - 2); // STAGEWIDTH/10が1ブロックでさ。
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("TETRIS");

        // rootノード。黒くしてるだけ
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #222;");

        // これでミノの描写をします。いろんなとこに引数としてウジャウジャしてると思います。
        Canvas cvs = new Canvas(STAGEWIDTH, STAGEHEIGHT);
        gra = cvs.getGraphicsContext2D();

        root.getChildren().add(cvs);
        stage.setScene(new Scene(root, STAGEWIDTH, STAGEHEIGHT));
        stage.show();
        depictionBranch();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
