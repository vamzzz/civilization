package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.media.AudioClip;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        Button investButton = new Button();
        Button demolishButton = new Button();
        investButton.setText("Invest");
        demolishButton.setText("Demolish");

        investButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile().
                    getOccupant().isBuilding()) {
                    if (GameController.getCivilization().getTreasury().
                        getCoins() >= 25) {
                        ((Building) GameController.getLastClicked().getTile().
                            getOccupant()).invest();
                        AudioClip invest1 = new AudioClip(
                            "File:./src/main/java/view/music/ChaChing.mp3");
                        invest1.play();
                        invest1.setVolume(.1);

                    } else {
                        AudioClip error = new AudioClip(
                            "File:./src/main/java/view/music/error.mp3");
                        error.play();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error");
                        alert.setTitle("You don't have enough coins to build.");
                        alert.showAndWait();
                    }
                }
            });


        demolishButton.setOnMousePressed(e -> {
                if (GameController.getCivilization().getNumSettlements() > 1) {
                    if (GameController.getLastClicked().getTile().
                        getOccupant() instanceof Settlement) {
                        AudioClip destroy = new AudioClip(
                            "File:./src/main/java/view/music/destroy.mp3");
                        destroy.play();
                        GameController.getLastClicked().getTile().
                            setOccupant(null);
                        GameController.getCivilization().
                            decrementNumSettlements();
                    }
                    if (GameController.getLastClicked().getTile().
                        getOccupant().isBuilding()) {
                        AudioClip destroy = new AudioClip(
                            "File:./src/main/java/view/music/destroy.mp3");
                        destroy.play();
                        GameController.getLastClicked().getTile()
                            .setOccupant(null);

                    }
                }

            });

        GameController.updateResourcesBar();
        super.addMenuItem(investButton);
        super.addMenuItem(demolishButton);

    }
}
