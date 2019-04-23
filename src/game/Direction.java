package game;

public interface Direction {
    Position next(Position current);

    Direction UP = p->new Position(p.getX(), p.getY()-1);
    Direction DOWN = p->new Position(p.getX(), p.getY()+1);
    Direction LEFT = p->new Position(p.getX()-1, p.getY());
    Direction RIGHT = p->new Position(p.getX()+1, p.getY());
}
