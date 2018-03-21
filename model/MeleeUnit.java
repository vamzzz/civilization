package model;

public class MeleeUnit extends MilitaryUnit {

    public MeleeUnit(Civilization civ) {
        super(100,  civ, 10, 10, 14, 5, 0, 30);

    }

    @Override
    public String toString() {
        return "MeleeUnit" + super.toString();
    }

    @Override
    public void battle(MapObject maps) {
        maps.damage(this.getDamage());
        if (!maps.isDestroyed() && (maps instanceof MeleeUnit
            || maps instanceof HybridUnit)) {
            damage(((MilitaryUnit) maps).getDamage());
        }
    }

    public char symbol() {
        return 'M';
    }
}