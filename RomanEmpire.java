public class RomanEmpire {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River();
    private Technology tech = new Technology();
    private Strategy strategy = new Strategy();
    private Settlement[] settlement = new Settlement[10];
    private int numSettlements = 0;
    private Hills hill = new Hills();

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

    public Hills getHills() {
        return hill;
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

    public boolean buildAqueduct(Settlement stuff) {
        boolean a = stuff.build(getTreasury().getCoins(),
            getPopulation(), 250, 130);
        if (a) {
            tech.increaseExperience(10);
        }
        return a;
    }

    public boolean buildBathHouse(Settlement bath) {
        boolean a = bath.build(getTreasury().getCoins(),
            getPopulation(), 110, 20);
        if (a) {
            tech.increaseExperience(10);
        }
        return a;
    }

    public boolean buildVilla(Settlement villa) {
        boolean a = villa.build(getTreasury().getCoins(),
            getPopulation(), 80, 15);
        if (a) {
            tech.increaseExperience(10);
        }
        return a;
    }

    public void studyPhilosophy() {
        population.decreaseHappiness(10);
        tech.philosophize();
    }
}