package src.fr.univavignon.ceri.application;

import javafx.geometry.Point2D;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Map;
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
		
		GuiController.canvasDimensions = new Point2D(
			800,
			800
		);
		
	}
	
	@FXML
    void nextPlayer(ActionEvent event) {
		System.out.println("Next player !");
		Map.clearActive();
		Game.nextPlayer();
    }
	
	/**
	 * Render all the {@code Entities} and {@code Tiles} present on the {@code Map}
	 */
	public static void render() {
		Draw.drawTiles();
		Draw.drawEntities();
	}
	
}
