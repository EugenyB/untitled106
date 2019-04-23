package game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controller {
    @FXML private Pane pane;
    @FXML private Canvas canvas;

    private GameField field;
    private GameView view;

    private Timeline timeline;

    @FXML
    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());

        field = GameField.create(20,20);
        view = GameView.create(field, canvas);

        timeline = new Timeline(new KeyFrame(Duration.millis(1000), e->processTick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void processTick() {
        field.tick();
        draw();
    }

    private void draw() {
        if (view!=null) {
            view.draw();
        }
    }

    public void processKey(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case LEFT: field.getKolobok().setDir(Direction.LEFT);
            break;
            case RIGHT: field.getKolobok().setDir(Direction.RIGHT);
            break;
            case UP: field.getKolobok().setDir(Direction.UP);
            break;
            case DOWN: field.getKolobok().setDir(Direction.DOWN);
            break;
        }
    }
}
