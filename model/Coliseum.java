package model;

public class Coliseum extends Landmark {

    private static int num = 0;

    public Coliseum(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Coliseum " + super.toString();
    }

    @Override
    public void invest() {
        if (num == 0) {
            super.setTechPointGeneration(5);
            ((Building) this).setHappinessGeneration(60);
        }
    }
}