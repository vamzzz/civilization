package model;

public class RangedUnit extends MilitaryUnit {

    protected int base = 10;

    public RangedUnit(Civilization civ) {
        super(100,  civ, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && (o instanceof HybridUnit
            || o instanceof RangedUnit)) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public String toString() {
        return "Ranged Unit" + super.toString();
    }

    public char symbol() {
        return 'R';
    }
}