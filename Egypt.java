public class Egypt {

    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River();
    private Technology tech = new Technology();
    private Strategy strategy = new Strategy();
    private Settlement[] settlement = new Settlement[10];
    private int numSettlements = 0;
    private Desert desert = new Desert();

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

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public Strategy getStrategy() {
        return strategy;
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

    public int getNumSettlements() {
        return numSettlements;
    }

    public Settlement[] getSettlements() {
        return settlement;
    }

    public River getRiver() {
        return river;
    }

    public Desert getDesert() {
        return desert;
    }

    public boolean buildPyramid(Settlement build) {
        Boolean a = build.build(getTreasury().getCoins(),
            getPopulation(), 500, 100);
        if (a) {
            tech.increaseExperience(10);
        }
        return a;
    }

    public void practiceHieroglyphics() {
        tech.improveWriting();
        population.increaseHappiness(10);
    }
}