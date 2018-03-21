public class Treasury {
    private int coins = 200;

    public int getCoins() {
        return coins;
    }
    public boolean spend(int cost) {
        if (cost >= coins) {
            coins = (coins - cost);
            return true;
        }
        return false;
    }

    public void earn(int c) {
        coins = coins + c;
    }
}