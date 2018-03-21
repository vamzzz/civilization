package view;

import controller.GameController;
import model.Convertable;
import javafx.scene.control.Alert;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        Button convertButton = new Button();
        Button moveButton = new Button();
        convertButton.setText("Convert");
        moveButton.setText("Move");

        moveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GameController.moving();
            }
        });

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (GameController.getLastClicked().getTile().
                    getOccupant().isWorker()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(((Convertable) GameController.
                        getLastClicked().getTile().getOccupant()).convert());
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(
                        "You cannot convert this tile into a building.");
                    alert.setTitle("Please try again.");
                    GameController.updateResourcesBar();
                    alert.showAndWait();
                }
            }
        });

        super.addMenuItem(moveButton);
        super.addMenuItem(convertButton);
    }
}
