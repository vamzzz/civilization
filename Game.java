public class Game {

    private int healthIncrease;

    public Game(int health) {
        this.healthIncrease = health;
    }

    public Game() {
        healthIncrease = 20;
    }

    public int getHealth() {
        return healthIncrease;
    }
}

