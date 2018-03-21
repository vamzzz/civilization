package view;

import controller.GameController;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        ObservableList<String> recruit = FXCollections.
            observableArrayList("Meelee Unit",
            "Ranged Unit", "Hybrid Unit", "Siege Unit", "Settlers",
            "Farmers", "Coal Miners", "Anglers", "Master Builders");
        ListView<String> listView = new ListView<String>(recruit);

        Button selectButton = new Button();
        selectButton.setText("Select");

        addMenuItem(listView);
        addMenuItem(selectButton);

        Unit meleeUnit = GameController.getCivilization().getMeleeUnit();
        Unit hybridUnit = GameController.getCivilization().getHybridUnit();
        Unit rangedUnit = GameController.getCivilization().getRangedUnit();
        Unit siegeUnit = GameController.getCivilization().getSiegeUnit();
        Unit settler = GameController.getCivilization().getSettlerUnit("Test");
        Unit farmer = GameController.getCivilization().getFarmerUnit();
        Unit coalmine = GameController.getCivilization().getCoalMinerUnit();
        Unit angler = GameController.getCivilization().getAnglerUnit();
        Unit master = GameController.getCivilization().getMasterBuilderUnit();


        selectButton.setOnMousePressed(e -> {
                String selected = listView.getSelectionModel().
                    getSelectedItem();

                if (selected.equals("Meelee Unit") && meleeUnit.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(meleeUnit);

                } else if (selected.equals("Ranged Unit") && rangedUnit.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(rangedUnit);

                } else if (selected.equals("Hybrid Unit") && hybridUnit.
                        isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(hybridUnit);

                } else if (selected.equals("Siege Unit") && siegeUnit.
                        isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(siegeUnit);

                } else if (selected.equals("Settlers") && settler.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(settler);

                } else if (selected.equals("Farmers") && farmer.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(farmer);

                } else if (selected.equals("Coal Miners") && coalmine.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(coalmine);

                } else if (selected.equals("Anglers") && angler.
                        isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(angler);

                } else if (selected.equals("Master Builders") && master.
                    isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(master);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Warning");
                    alert.setTitle(
                        "You don't have enough coins to make this unit.");
                    alert.showAndWait();
                }
                GameController.getLastClicked().updateTileView();
                GameController.setLastClicked(null);

            });
    }
}