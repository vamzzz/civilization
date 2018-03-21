import java.util.Random;

public class River {

    private static Random rand = new Random();
    private static String name = "Yellow Jacket";
    private Fish[] fish;
    private int numFish;


    public String getName() {
        return name;
    }

    public River() {
        fish = new Fish[5];
        numFish = 0;
        replenishFish();
    }
    private int count = 0;

    public Fish getFish() {
        if (count < 5) {
            count++;
            return fish[count - 1];
        }
        return null;
    }

    public boolean replenishFish() {
        if (numFish == 0) {
            for (int i = 0; i < fish.length; i++) {
                fish[i] = new Fish(rand.nextInt(20));
            }
            numFish = fish.length;
            return true;
        }
        return false;
    }
}