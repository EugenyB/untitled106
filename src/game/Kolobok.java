package game;

public class Kolobok {
    private int x;
    private int y;
    Direction dir = Direction.DOWN;

    public Kolobok(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Kolobok(GameField f) {
        x = f.getWidth() / 2;
        y = f.getHeight() / 2;
    }

    public void move() {
        Position next = dir.next(new Position(x, y));
        x = next.getX();
        y = next.getY();
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
