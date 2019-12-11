package src.fr.univavignon.ceri.application;

import javafx.geometry.Point2D;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
    
    @FXML
    private Button newGame;

    @FXML
    private Button loadGame;
    
    @FXML
    private Button credits;
    
    @FXML
    private Button exit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("Loaded MainMenu");
		
	}

    @FXML
    void start(ActionEvent event) {

		GuiController.game = Game.getInstance();
		
		GuiController.render();
		
		this.switchTo(Main.gameScene);
    }
    
    @FXML
    void newGame(ActionEvent event) {
    	this.switchTo(Main.newGameScene);
    }

    @FXML
    void loadGame(ActionEvent event) {
    	this.switchTo(Main.loadGameScene);
    }
    
    @FXML
    void credits(ActionEvent event) {
    	this.switchTo(Main.creditsScene);
    }

    @FXML
    void exit(ActionEvent event) {
    	Platform.exit();
        System.exit(0);
    }
    
    /**
	 * Switch the scene to the Game one
	 */
	private void switchTo(Scene scene) {		
		Stage primaryStage = (Stage) this.root.getScene().getWindow();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		System.out.println("Scene switched !");
	}
	
}
