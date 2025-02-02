package src.fr.univavignon.ceri.application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoadGameController implements Initializable {

	@FXML
    private Pane canvasPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Button back;
    
    @FXML
    private Button load;
    
    @FXML
    private ListView<String> listSaves;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		System.out.println("Loaded LoadGame");
		this.getSaveFiles();
	}

    @FXML
    void back(ActionEvent event) {
    	this.switchTo(Main.mainMenuScene);
    }
    
    @FXML
    void load(ActionEvent event) {
    	// TODO: Make the save process
    	int index = this.listSaves.getSelectionModel().getSelectedIndex();
    	
    	if (index == -1) {
    		System.out.println("Nothing selected");
		} else {
			System.out.println(this.listSaves.getItems().get(index));
	    	System.out.println("Load the save selected !");
		}
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
    
    /**
	 * Return all the file inside the saves folder
	 */
	private void getSaveFiles() {
		
		String dirPath = "saves/";
		File dir = new File(dirPath);
		String[] files = dir.list();
		
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
	        
			this.listSaves.getItems().clear();
			
			// For each save in the directory
		    for (String aFile : files) {
		    	
		    	// Filter by extension
		    	if (aFile.toLowerCase().endsWith(".sv")) {
					this.listSaves.getItems().add(aFile);
				}
		    	
		    }
		}
		
	}
	
}
