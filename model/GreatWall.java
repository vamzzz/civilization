package model;

public class GreatWall extends Landmark {

    private static int num = 0;

    public GreatWall(Civilization civ) {
        super(civ);
    }

    @Override
    public String toString() {
        return "Great Wall " + super.toString();
    }

    @Override
    public void invest() {
        if (num == 0) {
            super.setTechPointGeneration(5);
            ((MapObject) this).getOwner().getStrategy().invest();
            num++;
        }
    }
}