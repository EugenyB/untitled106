package game;

public class GameField {
    private int width;
    private int height;

    private Kolobok kolobok;

    private GameField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static GameField create(int width, int height) {
        GameField gameField = new GameField(width, height);
        gameField.kolobok = new Kolobok(gameField);
        return gameField;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
