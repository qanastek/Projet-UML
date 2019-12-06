package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import services.Draw;

public class GuiController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Draw.drawTiles();
		
	}
	
	
}
