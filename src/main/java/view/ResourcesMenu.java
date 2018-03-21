package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;


public class ResourcesMenu {

    private Civilization civ = GameController.getCivilization();
    private int stratLevel;
    private int resources;
    private int settlements;
    private int money;
    private int food;
    private int happy;
    private Text strat = new Text();
    private Text res = new Text();
    private Text sett = new Text();
    private Text mon = new Text();
    private Text foo = new Text();
    private Text hap = new Text();
    private HBox hbox = new HBox(45, strat, res, sett, mon, foo, hap);
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        stratLevel = civ.getStrategy().getStrategyLevel();
        resources = civ.getResources();
        settlements = civ.getNumSettlements();
        money = civ.getTreasury().getCoins();
        food = civ.getFood();
        happy = civ.getHappiness();

        strat.setText("Strat Level: " + stratLevel);
        res.setText("Resources: " + resources);
        sett.setText("Settlements: " + settlements);
        mon.setText("Money: " + money);
        foo.setText("Food: " + food);
        hap.setText("Happiness: " + happy);

    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return hbox;

    }
}