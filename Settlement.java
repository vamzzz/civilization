public class Settlement {
    private Building[] building = new Building[1];
    private String name;

    public void addBuilding(Building build) {
        for (int count = 0; count < building.length; count++) {
            if (building[count] == null) {
                building[count] = build;
                count = building.length;
            } else if (count == (building.length - 1)) {
                expandSettlement();
            }
        }
    }

    public Settlement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void expandSettlement() {
        int size = building.length;
        Building[] duplicate = new Building[2 * size];
        for (int list = 0; list < building.length; list++) {
            duplicate[list] = building[list];
        }
        building = duplicate;
    }

    public boolean build(int allotedMoney, Population population,
        int cost, int workersRequired) {
        if (cost <= allotedMoney
            &&
            workersRequired <= population.getCivilians()) {
            Building skyscraper = new Building(cost, workersRequired);
            addBuilding(skyscraper);
            return true;
        }
        return false;
    }
}