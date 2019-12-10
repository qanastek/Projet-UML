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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.services.Draw;

public class MainMenuController implements Initializable {

	@FXML
    private AnchorPane root;
	
	@FXML
    private Pane canvasPane;

    @FXML
    private Button start;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("Loaded MainMenu");
		
	}

    @FXML
    void start(ActionEvent event) {

		GuiController.game = Game.getInstance();
		
		GuiController.render();
		
		this.switchToGui();
    }
    
    /**
	 * Switch the scene to the Game one
	 */
	private void switchToGui() {		
		Stage primaryStage = (Stage) root.getScene().getWindow();
		
        primaryStage.setTitle("IN GAME");
		primaryStage.setScene(Main.scene);
		primaryStage.show();
		
		System.out.println("Scene switched !");
	}
	
}
