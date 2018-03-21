package model;

class QinDynasty extends Civilization {

    private Hills hills = new Hills();
    private int count;

    public QinDynasty(String name) {
        super(name);
    }

    public QinDynasty() {
        this("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        if (count == 9) {
            hills.replenishGame();
            count = 0;
        }
        int increased = hills.hunt().getHealth();
        food += increased;
        count++;
        return "You explored your surroundings and acquired "
            + increased + " food!";
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}
