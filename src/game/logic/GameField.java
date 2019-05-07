package game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GameField {
    private int width;
    private int height;

    private Kolobok kolobok;
    private List<Food> foods;

    private GameField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static GameField create(int width, int height) {
        GameField gameField = new GameField(width, height);
        gameField.kolobok = new Kolobok(gameField);
        gameField.foods = gameField.prepareFoods(width, height);
        return gameField;
    }

    private List<Food> prepareFoods(int width, int height) {
        int size = width * height / 20;
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addFood(foods, kolobok);
        }
        return foods;
    }

    private void addFood(List<Food> foods, Kolobok kolobok) {
        Random rnd = new Random();
        Position p;
        do {
            p = new Position(rnd.nextInt(width), rnd.nextInt(height));
        } while (!isValid(p,foods,kolobok));
        foods.add(new Food(p));
    }

    private boolean isValid(Position p, List<Food> foods, Kolobok k) {
        boolean b = foods.stream().map(Food::getPosition).noneMatch(pos -> pos.equals(p));
        return !k.getPosition().equals(p) && b;
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

    public Kolobok getKolobok() {
        return kolobok;
    }

    public void tick() {
        kolobok.move();
        Optional<Food> food = foods.stream()
                .filter(f -> f.getPosition().equals(kolobok.getPosition()))
                .findFirst();
        if (food.isPresent()) {
            foods.remove(food.get());
            addFood(foods, kolobok);
        }
    }

    public List<Food> getFoods() {
        return foods;
    }
}
