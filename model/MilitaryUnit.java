package model;

abstract class MilitaryUnit extends Unit {
    private int damage;

    public int getDamage() {
        return damage;
    }

    public int setDamage(int dam) {
        damage = dam;
        return damage;
    }

    public MilitaryUnit(int health, Civilization civ,
        int baseEndurance, int pay, int initialGoldCost,
        int initialFoodCost, int initialResourceCost, int damage) {
        super(health, civ, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        setDamage(damage);
    }

    @Override
    public void tick() {
        super.tick();
        super.setCanAttack(true);
    }

    public void battle(MapObject mapObject) {
    }

    public void attack(MapObject maps) {
        maps.getOwner().getStrategy().battle();
        this.battle(maps);
        super.setCanAttack(false);
    }

    @Override
    public String toString() {
        return "Military Unit" + super.toString();
    }
}