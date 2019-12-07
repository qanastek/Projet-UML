/**
 * 
 */
package models;

import java.util.Date;
import java.util.Iterator;

import models.entities.Entity;
import models.entities.EntityManager;
import models.entities.Player;

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
	public static EntityManager entityManager;
	public static Map map;
	public static Player currentPlayer;
	public static Iterator<Player> iteratorPlayer;
	
	/**
	 * Constructor
	 */
	private Game() {
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

}
