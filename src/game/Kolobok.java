package game;

public class Kolobok {
    private int x;
    private int y;
    Direction dir = Direction.DOWN;
    private GameField field;

    public Kolobok(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Kolobok(GameField f) {
        field = f;
        x = f.getWidth() / 2;
        y = f.getHeight() / 2;
    }

    public void move() {
        int width = field.getWidth();
        int height = field.getHeight();
        Position next = dir.next(new Position(x, y));
        x = (next.getX()+width) % width;
        y = (next.getY()+height) % height;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
