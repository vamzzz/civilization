package model;

public class SettlerUnit extends Unit implements Convertable {

    private String townName;

    public SettlerUnit(Civilization civ, String townName) {
        super(civ);
        this.townName = townName;
    }

    @Override
    public boolean canConvert(TileType type) {
        return type.equals(TileType.PLAINS);
    }

    @Override
    public String toString() {
        return "Settlers of " + townName + super.toString();
    }

    public char symbol() {
        return 's';
    }

    public Building convert() {
        this.getOwner().incrementNumSettlements();
        return this.getOwner().getSettlement(townName);
    }
}