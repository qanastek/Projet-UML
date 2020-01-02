package src.fr.univavignon.ceri.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	public static Scene gameScene, mainMenuScene, newGameScene, loadGameScene, escapeMenuScene, creditsScene, winMenu;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Set the title of the window
			primaryStage.setTitle("Projet UML - V1.3");
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/Game.fxml"));
			Main.gameScene = new Scene(root,800,800);
			Main.gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			AnchorPane mainMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/MainMenu.fxml"));
			Main.mainMenuScene = new Scene(mainMenu,800,800);
			
			AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/LoadGame.fxml"));
			Main.loadGameScene = new Scene(newGame,800,800);
			
			AnchorPane loadGame = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/NewGame.fxml"));
			Main.newGameScene = new Scene(loadGame,800,800);
			
			AnchorPane escapeMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/EscapeMenu.fxml"));
			Main.escapeMenuScene = new Scene(escapeMenu,800,800);
			
			AnchorPane creditsMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/CreditsMenu.fxml"));
			Main.creditsScene = new Scene(creditsMenu,800,800);

			AnchorPane winMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("vues/WinMenu.fxml"));
			Main.winMenu = new Scene(winMenu,800,800);
			
			primaryStage.setScene(Main.mainMenuScene);
			primaryStage.show();
			
			this.keyPressedHandler();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * When click on a keyboard key
	 */
	private void keyPressedHandler() {
		Main.gameScene.setOnKeyPressed(e -> {
			
			// If this key is ESC
		    if (e.getCode() == KeyCode.ESCAPE) {
		        System.out.println("A key was pressed");
		        Main.switchTo(Main.escapeMenuScene);
		    }
		});
	}
    
    /**
	 * Switch the scene to the Game one
	 */
	public static void switchTo(Scene scene) {		
		Stage primaryStage = (Stage) Main.gameScene.getWindow();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		System.out.println("Scene switched !");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
