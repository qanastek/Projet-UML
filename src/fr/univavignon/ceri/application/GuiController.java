package src.fr.univavignon.ceri.application;

import javafx.geometry.Point2D;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.services.Draw;

public class GuiController implements Initializable {

	@FXML
    private AnchorPane root;
	
	@FXML
    private Pane canvasPane;
	
	@FXML
    private Canvas canvasMap;
	public static GraphicsContext gc;
	
	public static Point2D canvasDimensions;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GuiController.gc = this.canvasMap.getGraphicsContext2D();
		
		Game g = Game.getInstance();
		
		GuiController.canvasDimensions = new Point2D(
			800,
			800
		);
		
		Draw.drawTiles();
	}
	
}
