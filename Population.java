import java.util.Random;

public class Population {
    private Random rand = new Random();
    private int warriors = 50;
    private int civilians = 50;
    private int happiness = 200;

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public int getWarriors() {
        return warriors;
    }

    public int getCivilians() {
        return civilians;
    }

    public void increaseHappiness(int increase) {
        happiness += increase;
    }

    public void decreaseHappiness(int decrease) {
        happiness -= decrease;
        if (happiness < 0) {
            happiness = 0;
        }
    }

    public void setWarriors(int present) {
        warriors = present;
    }

    public boolean canWork(int workers) {
        if (workers >= civilians) {
            civilians -= workers;
            return true;
        }
        return false;
    }

    public Game hunt(Hills result) {
        return result.hunt();
    }

    public Fish fish(River fishing) {
        return fishing.getFish();
    }

    public boolean canCook(Game game, CoalMine coal) {
        if (coal.getCoal() >= 40) {
            int count = 0;
            while (count < 5) {
                coal.burn();
                count++;
            }
            warriors += 40;
            civilians += 60;
            return true;
        }
        return false;
    }

    public boolean canCook(Fish fish, CoalMine coal) {
        if (coal.getCoal() >= 40) {
            int count = 0;
            while (count < 5) {
                coal.burn();
                count++;
            }
            warriors += 10;
            civilians += 15;
            return true;
        }
        return false;
    }

}