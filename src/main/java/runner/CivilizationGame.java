package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GridFX;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import model.Civilization;
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import java.util.Optional;
import javafx.scene.media.AudioClip;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private StartScreen startScreen = new StartScreen();
    private ListView<CivEnum> civ = startScreen.getCivList();
    private Boolean sButtonPress = false;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vamshi's CivilizationGame");
        //primaryStage.setResizable(false);

        Button button = startScreen.getStartButton();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AudioClip start = new AudioClip(
                    "File:./src/main/java/view/music/start.mp3");
                start.play();
                start.setVolume(.1);
                sButtonPress = true;

                primaryStage.setWidth(1200);
                primaryStage.setHeight(700);
                primaryStage.setScene(startGame());
                primaryStage.show();
            }
        });
        primaryStage.setScene(startGame());
        primaryStage.show();
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        AudioClip theme = new AudioClip(
            "File:./src/main/java/runner/theme.mp3");
        theme.play();
        theme.setVolume(.1);
        Application.launch(args);
    }


    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        if (!sButtonPress) {
            return new Scene(startScreen);
        }
        CivEnum selected = civ.getSelectionModel().getSelectedItem();
        Map map = GridFX.getInstance().getMap();
        TextInputDialog input = new TextInputDialog();


        input.setTitle("Congratulations!");
        input.setHeaderText(null);
        input.setContentText("What is the name of your first Settlement?");
        Optional<String> result = input.showAndWait();

        String nameSettlement = result.get();

        if (selected == CivEnum.ANCIENT_EGYPT) {
            Civilization civilization = new Egypt();
            GameController.setCivilization(civilization);
            map.putSettlement(nameSettlement, civilization, 0, 9);

        } else if (selected == CivEnum.ROMAN_EMPIRE) {
            Civilization civilization = new RomanEmpire();
            GameController.setCivilization(civilization);
            map.putSettlement(nameSettlement, civilization, 0, 9);

        } else if (selected == CivEnum.QIN_DYNASTY) {
            Civilization civilization = new QinDynasty();
            GameController.setCivilization(civilization);
            map.putSettlement(nameSettlement, civilization, 0, 9);
        }

        Bandit bandit = new Bandit();
        GameController.setBandits(bandit);
        map.addEnemies(bandit, 1);

        GameScreen gameScreen = new GameScreen();
        gameScreen.update();
        return new Scene(gameScreen);
    }
}
