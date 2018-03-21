package view;

import controller.GameController;
import javafx.scene.control.Button;


/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        super();
        Button attackButton = new Button("Attack");
        Button moveButton = new Button("Move");

        super.addMenuItem(attackButton);
        super.addMenuItem(moveButton);

        attackButton.setOnMouseClicked(e -> {
                GameController.attacking();
            });

        moveButton.setOnAction(event -> {
                GameController.moving();
            });

    }
}
