package model;

public class FarmerUnit extends Unit implements Convertable {

    @Override
    public boolean canConvert(TileType type) {
        return type.equals(TileType.PLAINS);
    }

    public FarmerUnit(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Farmer" + super.toString();
    }

    public char symbol() {
        return 'f';
    }

    public Building convert() {
        return this.getOwner().getFarm();
    }
}