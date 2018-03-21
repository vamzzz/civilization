package model;

public class AnglerUnit extends Unit implements Convertable {

    @Override
    public boolean canConvert(TileType type) {
        return type.equals(TileType.WATER);
    }

    public AnglerUnit(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Anglers " + super.toString();
    }

    public char symbol() {
        return 'a';
    }

    public Building convert() {
        return this.getOwner().getFishingShack();
    }

}