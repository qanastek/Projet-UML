package src.fr.univavignon.ceri.application;

import javafx.geometry.Point2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.entities.Player;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.items.props.Chest;
import src.fr.univavignon.ceri.application.services.Draw;

public class GuiController implements Initializable {

	@FXML
    private AnchorPane root;
	
	@FXML
    private Pane canvasPane;
	
	@FXML
    private Button nextPlayer;
	
	@FXML
    private Canvas canvasMap;
	public static GraphicsContext gc;
	
	public static Game game;
	
	public static Point2D canvasDimensions;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GuiController.gc = this.canvasMap.getGraphicsContext2D();
		
		// Setup the canvas dimensions
		GuiController.canvasDimensions = new Point2D(
			800,
			800
		);
		
		// When we click on the canvas
		this.canvasMap.setOnMouseClicked(event -> {
			
			// If the current player is a real player
			if (Game.currentPlayer instanceof Player) {
				
				// Move on the Tile
				((Player) Game.currentPlayer).move(event.getX(), event.getY());
				this.checkChest();
				GuiController.render();
				Game.nextPlayer();
			}
		});
	}
	


	/**
	 * Check if the player got the {@code Chest}
	 * @param item {@code Item}
	 */
	public void checkChest() {
		
		System.out.println("Search for chest");
		
		ArrayList<Item> playerInventory = Game.currentPlayer.getInventory().getContent();
		
		for (int i = 0; i < playerInventory.size(); i++) {
			
			Item item = playerInventory.get(i);

			System.out.println("check: " + item.getClass().getSimpleName().toString());
			
			if (item instanceof Chest) {
				System.out.println("Win !!!!!!!!!");
				this.win();
			}
		}
		
	}
	
	@FXML
    void nextPlayer(ActionEvent event) {
		Game.nextPlayer();
    }
	
	/**
	 * Render all the {@code Entities} and {@code Tiles} present on the {@code Map}
	 */
	public static void render() {
		Draw.drawTiles();
		Draw.drawEntities();
		Draw.drawItems();
	}
	
	public void win() {
		Game.saveGame();
		this.switchTo(Main.mainMenuScene);
	}

	/**
	 * The end game screen when all the {@code Player}'s are dead
	 */
	public static void lose() {
		System.out.println("Every single Player are dead !");
		Game.sleep(Integer.MAX_VALUE);
	}
	
    /**
	 * Switch the scene
	 */
	public void switchTo(Scene scene) {		
		Stage primaryStage = (Stage) this.root.getScene().getWindow();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		System.out.println("Scene switched !");
	}
	
}
