package model;

public class Pyramid extends Landmark {

    public Pyramid(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Pyramid " + super.toString();
    }

    @Override
    public void invest() {
        super.setTechPointGeneration(5);
        setPhilosophyGeneration(25);
    }
}