package model;

public class CoalMinerUnit extends Unit implements Convertable {

    @Override
    public boolean canConvert(TileType type) {
        return type.equals(TileType.HILLS);
    }

    public CoalMinerUnit(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Coal Miner " + super.toString();
    }

    public char symbol() {
        return 'c';
    }

    public Building convert() {
        return this.getOwner().getCoalMine();
    }
}