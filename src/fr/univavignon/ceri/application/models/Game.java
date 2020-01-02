/**
 * 
 */
package src.fr.univavignon.ceri.application.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.models.entities.Buccaneer;
import src.fr.univavignon.ceri.application.models.entities.Entity;
import src.fr.univavignon.ceri.application.models.entities.EntityManager;
import src.fr.univavignon.ceri.application.models.entities.Filibuster;
import src.fr.univavignon.ceri.application.models.entities.Pirate;
import src.fr.univavignon.ceri.application.models.entities.Player;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.items.props.Chest;
import src.fr.univavignon.ceri.application.models.items.props.Shovel;
import src.fr.univavignon.ceri.application.models.items.weapons.Armor;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;
import src.fr.univavignon.ceri.application.models.items.weapons.Musket;
import src.fr.univavignon.ceri.application.models.tiles.Tile;

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
	public static int currentPlayerIndex = 0;
	public static Entity currentPlayer;
	public static boolean status = false;
	
	/**
	 * Constructor
	 */
	private Game() {
		
		Game.qtsEnemy = 3;
		Game.mapSize = 10;

		Game.map = Map.getInstance(Game.mapSize);
		Map.generateTiles();
		Game.entityManager = EntityManager.getInstance();
		Game.generateBots();
		Game.generatePlayers();
		Game.placeEntities();
		Game.placeIntems();
		Game.status = true;
		
//		System.out.println(Game.map);
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
		
		if (Game.status == false) {
			return;
		}
		
		Map.clearActive();
		
		// If the next player exist
		if (Game.currentPlayerIndex < EntityManager.entities.size()) {
			
			// The current Player entity
			Game.currentPlayer = EntityManager.entities.get(Game.currentPlayerIndex);
			
			// If the current player is a real player
			if (Game.currentPlayer instanceof Player) {
				System.out.println("-------------------- Player");
				Game.showMovableTiles(currentPlayer);
			}
			// If its a bot
			else {				
				System.out.println(Game.currentPlayer.getClass().getSimpleName());
				((Pirate) Game.currentPlayer).autoPlay();
			}

			Game.currentPlayerIndex++;
		}
		// Else return to the start of the list
		else {
			Game.currentPlayerIndex = 0;
			Game.nextPlayer();
		}
	}
	
	public static void pass() {
		
		Map.clearActive();
		
		// If the next player exist
		if (Game.currentPlayerIndex < EntityManager.entities.size()) {
			
			// If the current player is a real player
			if (EntityManager.entities.get(Game.currentPlayerIndex) instanceof Player) {
				Game.nextPlayer();
			}
			// If its a bot
			else {
				// The current Player entity
				Game.currentPlayer = EntityManager.entities.get(Game.currentPlayerIndex);			
				Game.currentPlayerIndex++;
			}
			
		}
		// Else return to the start of the list
		else {
			Game.currentPlayerIndex = 0;
			Game.pass();
		}
	}
	
	/**
	 * Show all the {@code Tile} were the {@code Player} can go on.
	 * @param entity {@code Entity} The current player
	 */
	public static void showMovableTiles(Entity entity) {
		
		// For each Tile of the Map
		for (Tile[] line : Map.matrix) {
			for (Tile tile : line) {
				
				// Get the distance with the Tile
				int distance = Game.currentPlayer.distance(tile);
				
				// If the Player can reach the Tile
				if (distance <= Game.currentPlayer.getWalkStep()) {
					tile.toggleActive();
				}				
			}
		}
		
		GuiController.render();
	}
	
	/**
	 * Return all the {@code Node}'s were the current {@code Player} can go on.
	 * @return {@code ArrayList<Tile>} All the {@code Tile}'s
	 */
	public static ArrayList<Tile> getMovableTiles() {
		
	    ArrayList<Tile> accessibles = new ArrayList<Tile>();
		
		// For each Tile of the Map
		for (Tile[] line : Map.matrix) {
			for (Tile tile : line) {
				
				int distance = Game.currentPlayer.distance(tile);
				
				// If the Player can reach the Tile
				if (distance <= Game.currentPlayer.getWalkStep()) {
					tile.toggleActive();
					accessibles.add(tile);
				}				
			}
		}
		
		GuiController.render();
		return accessibles;
	}
	
	/**
	 * Return a random player
	 * @return {@code Player} The player
	 */
	public static Player randomPlayer() {
		
		Iterator<Entity> it = EntityManager.entities.iterator();
		      
		while(it.hasNext()) {
			
			Entity entity = it.next();

			// If the distance is better
			if (entity instanceof Player) {
				return (Player) entity;
			}
		}
		
		return null;
	}
	
	/**
	 * Return the closest player
	 */
	public static Player closestPlayer() {
		
		Entity closest = null;
		int bestDistance = Integer.MAX_VALUE;
		int distance = 0;
		
		Iterator<Entity> it = EntityManager.entities.iterator();
		      
		while(it.hasNext()) {
			
			Entity entity = it.next();
			
			distance = Game.currentPlayer.distance(entity);

			// If the distance is better
			if (entity instanceof Player && distance < bestDistance) {
				bestDistance = distance;
				closest = entity;
			}
		}

		System.out.println("-----------------------REUTRN CLSOEST-----------------");
		System.out.println(closest);
		return (Player) closest;
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

		Player player;
		player = new Player("qanastek", 1);	
		Game.entityManager.addEntity(player);
		
	}	
	
	public static void placeEntities() {
		
		for (Entity entity : EntityManager.getEntities()) {
			Point2D pos = Game.map.getRandomPosition();
			entity.move(pos);
		}
		
	}
	
	public static List<Item> generateItems() {
		
		List<Item> items = new ArrayList<Item>();
		
		int indexShovel = EntityManager.getNbrPlayer();
		System.out.println(indexShovel);
		
		int indexMachete = indexShovel + (EntityManager.getNbrPlayer() * 2);
		System.out.println(indexMachete);
		
		int indexMusket = indexMachete + (EntityManager.getNbrPlayer() * 2);
		System.out.println(indexMusket);
		
		int indexArmor = indexMusket + (EntityManager.getNbrPlayer() * 2);
		System.out.println(indexArmor);
		
		int indexChest = indexArmor + 1;
		System.out.println(indexChest);
		
		int i = 0;
		
		while (true) {
			
			Item item = null;
			
			if (i < indexShovel) {
				item = new Shovel();	
			}
			else if (i < indexMachete) {
				item = new Machete();
			}
			else if (i < indexMusket) {
				item = new Musket();	
			}
			else if (i < indexArmor) {
				item = new Armor();
			}
			else if (i < indexChest) {
				item = Chest.getInstance();
			}
			else {
				break;
			}
			
			items.add(item);
			
			i++;
		}
		
		return items;		
	}
	
	/**
	 * Place all the {@code Item}'s
	 */
	public static void placeIntems() {
		
		List<Item> items = Game.generateItems();
		
		for (Item item : items) {
			
			// Get a random Tile
			Tile t = Map.randomTileWithoutItem();
			
			// Add the Item to the Tile
			t.setContain(item);
		}
		
	}
	
	/**
	 * Sleep during n seconds
	 */
	public static void sleep(int duration) {
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sleep during n millisecond
	 */
	public static void sleep(long duration) {
		try {
			TimeUnit.MILLISECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * Save the {@code Game}
     */
    public static void saveGame() {
    	System.out.println("Save the game !");
	}

}
