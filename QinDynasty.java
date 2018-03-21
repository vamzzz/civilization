public class QinDynasty {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River();
    private Technology tech = new Technology();
    private Strategy strategy = new Strategy();
    private Settlement[] settlement = new Settlement[10];
    private int numSettlements = 0;
    private Hills hill = new Hills();

    public Strategy getStrategy() {
        return strategy;
    }

    public Hills getHills() {
        return hill;
    }

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public Technology getTechnology() {
        return tech;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public Population getPopulation() {
        return population;
    }

    public Settlement[] getSettlements() {
        return settlement;
    }

    public River getRiver() {
        return river;
    }
    public boolean settle(Settlement live) {
        for (int count = 0; count < settlement.length; count++) {
            if (settlement[count] == null) {
                settlement[count] = live;
                numSettlements++;
                return true;
            }
        }
        return false;
    }

    public int getNumSettlements() {
        return numSettlements;
    }

    public boolean buildWall(Settlement dude) {
        boolean a = dude.build(getTreasury().getCoins(), getPopulation(),
            1000, 100);
        if (a) {
            tech.increaseExperience(10);
        }
        return a;
    }

    public boolean buildHouse(Settlement house) {
        boolean b = house.build(getTreasury().getCoins(),
            getPopulation(), 30, 8);
        if (b) {
            tech.increaseExperience(10);
        }
        return b;
    }

    public void establishLegalism() {
        tech.philosophize();
        population.decreaseHappiness(20);
    }
}