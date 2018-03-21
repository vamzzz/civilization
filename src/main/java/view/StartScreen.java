package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button button = new Button();
    private ObservableList<CivEnum> civs = FXCollections.
        observableArrayList(CivEnum.QIN_DYNASTY,
        CivEnum.ROMAN_EMPIRE, CivEnum.ANCIENT_EGYPT);
    private ListView<CivEnum> listView = new ListView<CivEnum>(civs);
    private static Slider slider = new Slider(10, 20, 2);
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        Image image = new Image(
            "File:./src/main/java/view/civ_background.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1200);
        Text text = new Text("Select a Civilization!");
        text.setFill(Color.RED);
        text.setFont(Font.font("Verdana" , 25));

        button = getStartButton();
        slider = getSlider();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(slider, text, getCivList(), button);
        super.getChildren().addAll(imageView, vBox);
        vBox.setAlignment(Pos.BOTTOM_CENTER);

    }

    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        button.setText("Start");
        return button;
    }
    // *
    // * return a ListView of CivEnums representing the list of
    // * available civilizations to choose from
    // * @return listview of CivEnum
    public ListView<CivEnum> getCivList() {
        listView.setMaxHeight(100);
        listView.setMaxWidth(300);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        return listView;
    }

    public static Slider getSlider() {
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(600);
        slider.setMajorTickUnit(2.0);
        slider.setMinorTickCount(0);
        return slider;

    }
}


