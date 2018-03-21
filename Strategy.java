public class Strategy {

    private int strategyLevel = 0;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;
    private boolean conqueredTheWorld = false;


    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        if (strategyLevel >= 180) {
            conqueredTheWorld = true;
        }
    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        if (strategyLevel >= 180) {
            conqueredTheWorld = true;
        }
    }

    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }
}