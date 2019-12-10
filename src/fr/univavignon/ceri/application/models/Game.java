/**
 * 
 */
package src.fr.univavignon.ceri.application.models;

import java.util.Date;
import java.util.Iterator;

import javafx.geometry.Point2D;

import src.fr.univavignon.ceri.application.models.entities.Buccaneer;
import src.fr.univavignon.ceri.application.models.entities.Entity;
import src.fr.univavignon.ceri.application.models.entities.EntityManager;
import src.fr.univavignon.ceri.application.models.entities.Filibuster;
import src.fr.univavignon.ceri.application.models.entities.Pirate;
import src.fr.univavignon.ceri.application.models.entities.Player;

/**
 * @author Yanis Labrak
 *
 */
public class Game {

	private static Game instance = null;
	public static int saveId;
	public static Date creationDate;
	public static String name;
	public static int qtsEnemy;
	public static int mapSize;
	public static EntityManager entityManager;
	public static Map map;
	public static Iterator<Player> iteratorPlayer;
	public static Player currentPlayer;
	
	/**
	 * Constructor
	 */
	private Game() {
		
		Game.qtsEnemy = 3;
		Game.mapSize = 20;
s
		Game.map = Map.getInstance(Game.mapSize);
		Map.generateTiles();
		Game.entityManager = EntityManager.getInstance();
		Game.generateBots();
		Game.generatePlayers();
		Game.placeEntities();
		
		System.out.println(Game.map);
	}
	
	/**
	 * Get the singleton instance
	 * @return {@code Game} The instance
	 */
	public static Game getInstance() {
		if (Game.instance == null) {
			Game.instance = new Game();
			return instance;
		} else {
			return instance;
		}
	}
	
	public static void nextPlayer() {
		if (Game.iteratorPlayer.hasNext()) {
			Game.currentPlayer = Game.iteratorPlayer.next();			
		}
	}
	
	public static void showMovableTiles(Entity entity) {
		// TODO: Make the body
	}
	
	public static void win() {
		// TODO: Win the game
	}

	public static void lose() {
		// TODO: Lose the game
	}	
	
	public static void generateBots() {
		
		for (int i = 0; i < Game.qtsEnemy; i++) {
						
			Pirate pirate;
			
			// A third
			if (i < Math.ceil(Game.qtsEnemy * 0.33)) {
				pirate = new Buccaneer();
			}
			else {
				pirate = new Filibuster();	
			}
			
			Game.entityManager.addEntity(pirate);
		}
		
	}	
	
	public static void generatePlayers() {
		
		// TODO: Make the body
		
	}	
	
	public static void placeEntities() {
		
		for (Entity entity : EntityManager.getEntities()) {
			Point2D pos = Game.map.getRandomPosition();
			entity.move(pos);
		}
		
	}	

}
