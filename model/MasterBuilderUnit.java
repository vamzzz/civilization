package model;

public class MasterBuilderUnit extends Unit implements Convertable {

    public boolean canConvert(TileType type) {
        return type.equals(TileType.PLAINS);
    }

    public MasterBuilderUnit(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Master Builder" + super.toString();
    }

    public char symbol() {
        return 'm';
    }

    public Building convert() {
        return this.getOwner().getLandmark();
    }
}