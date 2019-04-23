package game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML private Pane pane;
    @FXML private Canvas canvas;

    private GameField field;
    private GameView view;

    @FXML
    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());

        field = GameField.create(20,20);
        view = GameView.create(field, canvas);
    }

    private void draw() {
        if (view!=null) {
            view.draw();
        }
    }
}
