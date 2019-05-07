package game.logic;

import java.util.Objects;

public class Food {
    private Position position;

    public Food(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(position, food.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
