package game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameView {
    private GameField field;
    private Canvas canvas;

    private GameView(GameField field, Canvas canvas) {
        this.field = field;
        this.canvas = canvas;
    }

    public static GameView create(GameField field, Canvas canvas) {
        GameView view = new GameView(field, canvas);
        return view;
    }

    public void draw() {
        GraphicsContext g2 = canvas.getGraphicsContext2D();
        g2.setFill(Color.WHITESMOKE);
        g2.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        g2.setStroke(Color.BLUEVIOLET);
        double cellWidth = canvas.getWidth() / (double) field.getWidth();
        double cellHeight = canvas.getHeight() / (double) field.getHeight();
        double cellSize = Double.min(cellHeight, cellWidth);
        for (int i = 0; i <= field.getWidth(); i++) {
            g2.strokeLine(i*cellSize, 0, i*cellSize, field.getHeight()*cellSize);
        }
        for (int i = 0; i <=field.getHeight() ; i++) {
            g2.strokeLine(0, i*cellSize, field.getWidth()*cellSize, i*cellSize);
        }
        int x = field.getKolobok().getX();
        int y = field.getKolobok().getY();
        g2.setFill(Color.RED);
        g2.fillOval(x*cellSize+2, y*cellSize+2, cellSize-4, cellSize-4);
    }
}
