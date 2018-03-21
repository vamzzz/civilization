package model;

public class WarChariot extends RangedUnit {

    public WarChariot(Civilization civ) {
        super(civ);
        setBaseEndurance(20);
    }

    @Override
    public String toString() {
        return super.toString() + " War Chariot Unit";
    }

    @Override
    public char symbol() {
        return 'W';
    }
}