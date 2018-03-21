package model;

public class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization civ) {
        super(civ);
        setDamage(45);
    }

    @Override
    public void battle(MapObject maps) {
        maps.damage(this.getDamage());
        if (!maps.isDestroyed() && maps instanceof MeleeUnit) {
            damage(((MilitaryUnit) maps).getDamage());
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Legion.";
    }

    @Override
    public char symbol() {
        return 'L';
    }

}