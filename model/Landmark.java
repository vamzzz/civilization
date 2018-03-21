package model;

public class Landmark extends Building {

    public Landmark(Civilization civ) {
        super(200, civ, 0, 0, 0, 10, 0, 10);
    }

    public void invest() {
        super.setTechPointGeneration(5);
    }

    public char symbol() {
        return '!';
    }

    @Override
    public String toString() {
        return "Landmark " + super.toString();
    }
}