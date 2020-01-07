package src.fr.univavignon.ceri.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fr.univavignon.ceri.application.models.Difficulty;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.MapSize;

public class NewGameController implements Initializable {

	@FXML
    private Button play;

    @FXML
    private Pane canvasPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Button back;
    
    @FXML
    private ComboBox<Difficulty> difficulty =  new ComboBox<Difficulty>();

    @FXML
    private ComboBox<MapSize> mapSize =  new ComboBox<MapSize>();
    
    public static Difficulty selectedDifficulty;
    public static MapSize selectedMapSize;
    
	public static ObservableList<Difficulty> listDifficulties = FXCollections.observableArrayList();
	public static ObservableList<MapSize> listMapSizes = FXCollections.observableArrayList();
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	/**
    	 * Add difficulties to the comboBox
    	 */
    	NewGameController.listDifficulties.setAll(
    		new Difficulty("Easy", 2),
	    	new Difficulty("Medium", 3),
	    	new Difficulty("Hard", 4),
	    	new Difficulty("God Of War", 5)
    	);
    	this.difficulty.getItems().addAll(NewGameController.listDifficulties);

    	/**
    	 * Add map sizes to the comboBox
    	 */
    	NewGameController.listMapSizes.setAll(
			new MapSize("5 x 5", 5),
	    	new MapSize("10 x 10", 10),
	    	new MapSize("15 x 15", 15)
    	);
    	this.mapSize.getItems().addAll(NewGameController.listMapSizes);
    	
    	System.out.println("Loaded");
	}
    
	@FXML
    void back(ActionEvent event) {
		this.switchTo(Main.mainMenuScene);
    }

    @FXML
    void play(ActionEvent event) {
    	this.switchTo(Main.mainMenuScene);
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

    @FXML
    void selectMapSize(ActionEvent event) {
    	NewGameController.selectedMapSize = this.mapSize.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selectDifficulty(ActionEvent event) {
    	NewGameController.selectedDifficulty = this.difficulty.getSelectionModel().getSelectedItem();
    }
	
}
