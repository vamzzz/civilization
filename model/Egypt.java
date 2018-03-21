package model;

class Egypt extends Civilization {

    private Desert desert = new Desert();

    public Egypt(String name) {
        super(name);
    }

    public Egypt() {
        this("Egypt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        super.getTreasury().earn(gold);
        return "You explored your surroundings and acquired "
            + gold + " gold!";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}
