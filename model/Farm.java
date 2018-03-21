package model;

public class Farm extends Building {

    public Farm(Civilization civ) {
        super(200, civ, 0, 0, 10, 0, 0, 10);
    }

    @Override
    public void invest() {
        super.setFoodGeneration(2);
    }

    public char symbol() {
        return '+';
    }

    @Override
    public String toString() {
        return "Farm" + super.toString();
    }
}