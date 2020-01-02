package src.fr.univavignon.ceri.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WinMenuController implements Initializable {

    @FXML
    private Pane canvasPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Button back;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Loaded NewGame");
	}
	
	@FXML
    void back(ActionEvent event) {
		this.saveGame();
		this.switchTo(Main.mainMenuScene);
    }
    
    /**
     * 
     */
    private void saveGame() {
    	System.out.println("Save the game !");
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