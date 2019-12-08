package src.fr.univavignon.ceri.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import src.fr.univavignon.ceri.application.services.Draw;

public class GuiController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Draw.drawTiles();
		
	}
	
}
