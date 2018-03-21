package model;

public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization civ) {
        super(civ);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

    @Override
    public String toString() {
        return super.toString() + "Black Powder Unit";
    }

    @Override
    public char symbol() {
        return 'B';
    }
}