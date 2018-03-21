package model;

public class SiegeUnit extends MilitaryUnit {

    public SiegeUnit(Civilization civ) {
        super(200,  civ, 5, 10, 14, 5, 10, 60);
    }

    public char symbol() {
        return 'S';
    }

    @Override
    public void battle(MapObject o) {
        if (o instanceof Building) {
            o.damage(this.getDamage());
        }
    }

    @Override
    public void attack(MapObject maps) {
        maps.getOwner().getStrategy().siege();
        this.battle(maps);
        super.setCanAttack(false);
    }
}