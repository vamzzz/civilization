package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Map;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {


    private Map map = GridFX.getMap();
    private static ResourcesMenu resources = new ResourcesMenu();
    private HBox resourcebar = resources.getRootNode();
    private static MilitaryMenu militarymenu = new MilitaryMenu();
    private static WorkerMenu workerMenu = new WorkerMenu();
    private static RecruitMenu recruitMenu = new RecruitMenu();
    private static BuildingMenu buildingMenu = new BuildingMenu();
    private static StatusMenu statusMenu = new StatusMenu();
    private static AbstractMenu general = new AbstractMenu();
    private static VBox vBox = new VBox(10, general.getRootNode());

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        this.setCenter(GridFX.getInstance());
        this.setTop(resourcebar);
        this.setLeft(vBox);

        //TODO
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        GameController.updateResourcesBar();

    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resources;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        vBox.getChildren().clear();
        if (state == GameController.GameState.MILITARY) {
            general = militarymenu;

        } else if (state == GameController.GameState.WORKER) {
            general = workerMenu;

        } else if (state == GameController.GameState.RECRUITING) {
            general = recruitMenu;

        } else if (state == GameController.GameState.BUILDING) {
            general = buildingMenu;

        } else if (state == GameController.GameState.NEUTRAL) {
            general = statusMenu;
        }

        vBox.getChildren().add(general.getRootNode());

        //update();
    }
}
