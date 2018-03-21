import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public int findTreasure() {
        int coin = rand.nextInt(500) + 1;
        int lost = rand.nextInt(10);
        if (lost == 0) {
            lost();
            if (!lost()) {
                findTreasure();
            }
            if (lost()) {
                lost();
            }
        }
        return coin;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}