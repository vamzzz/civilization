package view;


import controller.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.TerrainTile;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class TerrainTileFX extends StackPane {
    private Rectangle overlay;
    private ImageView background;
    private TerrainTile tile;
    private ImageView icon = new ImageView("File:./bologna");
    /**
     * Constructor for TerrainTileFX.
     * Creates a Rectangle for the highlighting and overlay
     * Creates ImageViews for the background terrain and icon
     * Transitions states when a tile is clicked
     * @param tile
     */
    public TerrainTileFX(TerrainTile tile) {
        int size = ((int) 700 / GridFX.getMapSize());
        this.tile = tile;
        overlay = new Rectangle(size, size, Color.rgb(0, 0, 0, 0.0));
        overlay.setStroke(Color.BLACK);
        this.background = new ImageView(tile.getImage());
        this.getChildren().addAll(background, overlay);
        updateTileView();
        this.setOnMousePressed(event -> {
                GameController.setLastClicked(this);
            });
    }

    public void set() {
        this.background.setFitWidth(((int) 700 / GridFX.getMapSize()));
        this.background.setFitHeight(((int) 700 / GridFX.getMapSize()));
    }
    /**
     * gets the TerrainTile of this TerrainTileFX
     * @return TerrainTile
     */
    public TerrainTile getTile() {
        return tile;
    }
    /**
     * this method updates the view of this TerrainTileFX.
     * It should check if the TerrainTile is empty. If it is empty,
     * set the overlay to be transparent. If it is not empty, fill
     * the overlay with the color of the occupant on the terrain tile
     * If the TerrainTileFX contains an icon, remove it. If the tile is
     * not empty, get the image of the occupant of the tile and add the
     *image of the occupant to the tile.
     */
    public void updateTileView() {
        this.getChildren().clear();
        TerrainTileFX lastClicked = GameController.getLastClicked();

        if (lastClicked == this) {
            overlay.setStroke(Color.RED);
            overlay.setFill(Color.rgb(0, 0, 1, .5));
            overlay.setWidth(((int) 700 / GridFX.getMapSize()));
        } else {
            overlay.setStroke(Color.BLACK);
        }

        if (tile.isEmpty()) {
            overlay.setFill(Color.rgb(0, 0, 0, 0.0));
            overlay.setWidth(((int) 700 / GridFX.getMapSize()));
            this.background = new ImageView(tile.getImage());
            this.set();
            this.getChildren().addAll(background, overlay);

        } else {
            overlay.setFill(tile.getOccupant().getColor());
            overlay.setWidth(((int) 700 / GridFX.getMapSize()));
            icon = new ImageView(tile.getOccupant().getImage());
            icon.setFitWidth(((int) 420 / GridFX.getMapSize()));
            icon.setFitHeight(((int) 420 / GridFX.getMapSize()));
            this.background = new ImageView(tile.getImage());
            this.set();
            this.getChildren().addAll(background, overlay, icon);

        }
    }
}
