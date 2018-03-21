package model;

class RomanEmpire extends Civilization {

    private Hills hills = new Hills();

    public RomanEmpire(String name) {
        super(name);
    }

    public RomanEmpire() {
        this("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        resources += hills.mineCoal();
        return "You explore your surroundings and acquire " + hills.mineCoal()
            +  " resources!";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }
}
