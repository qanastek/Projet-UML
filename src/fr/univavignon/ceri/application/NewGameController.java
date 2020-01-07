package src.fr.univavignon.ceri.application;

import java.net.URL;
import java.util.ResourceBundle;

import fr.univavignon.ceri.deskmap.controllers.MainViewController;
import fr.univavignon.ceri.deskmap.models.line.Road;
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
    private ComboBox<Difficulty> difficulty;

    @FXML
    private ComboBox<MapSize> mapSize;
    
    public static Difficulty selectedDifficulty;
    public static MapSize selectedMapSize;
    
	public static ObservableList<Difficulty> listDifficulties = FXCollections.observableArrayList();
	public static ObservableList<MapSize> listMapSizes = FXCollections.observableArrayList();
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {

    	/**
    	 * Add difficulties to the comboBox
    	 */
    	this.difficulty.setItems(NewGameController.listDifficulties);
    	NewGameController.listDifficulties.add(new Difficulty("Easy", 2));
    	NewGameController.listDifficulties.add(new Difficulty("Medium", 3));
    	NewGameController.listDifficulties.add(new Difficulty("Hard", 4));
    	NewGameController.listDifficulties.add(new Difficulty("God Of War", 5));

    	/**
    	 * Add map sizes to the comboBox
    	 */
    	this.mapSize.setItems(NewGameController.listMapSizes);
    	NewGameController.listMapSizes.add(new MapSize("5 x 5", 5));
    	NewGameController.listMapSizes.add(new MapSize("10 x 10", 10));
    	NewGameController.listMapSizes.add(new MapSize("15 x 15", 15));    	
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
