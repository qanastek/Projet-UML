package src.fr.univavignon.ceri.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	public static Scene gameScene, mainMenuScene, newGameScene, loadGameScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Set the title of the window
			primaryStage.setTitle("Projet UML - V1.3");
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/Gui.fxml"));
			Main.gameScene = new Scene(root,800,800);
			Main.gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			AnchorPane mainMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/MainMenu.fxml"));
			Main.mainMenuScene = new Scene(mainMenu,800,800);
			
			AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/LoadGame.fxml"));
			Main.loadGameScene = new Scene(newGame,800,800);
			
			AnchorPane loadGame = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/NewGame.fxml"));
			Main.newGameScene = new Scene(loadGame,800,800);
			
			primaryStage.setScene(Main.mainMenuScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
