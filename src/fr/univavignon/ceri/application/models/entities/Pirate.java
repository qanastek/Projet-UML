package src.fr.univavignon.ceri.application.models.entities;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.tiles.Tile;

/**
 * @author Yanis Labrak
 *
 */
public abstract class Pirate extends Entity {

	/**
	 * Constructor
	 * @param img  {@code String}
	 * @param coordinates {@code Point2D}
	 * @param walkStep {@code Integer}
	 */
	protected Pirate(String img, Point2D coordinates, int walkStep) {
		super(img, coordinates, walkStep);
	}	

	/**
	 * Constructor
	 * @param img
	 * @param walkStep
	 */
	protected Pirate(String img, int walkStep) {
		super(img, walkStep);
	}
	
	/**
	 * Play automatically
	 */
	public void autoPlay() {
		
		// Check if has Player left alive
		if (EntityManager.checkHasPlayerLeft() == false) {
			GuiController.lose();
		}
		
		System.out.println("Autoplay");
//		System.out.println(Game.currentPlayer);
		
//		Game.sleep(1);
		
		Player p = Game.randomPlayer();
		
		if (p != null) {
			
			Tile closest = null;
			int bestDistance = Integer.MAX_VALUE;
			int distance;

			// Get the closest Tile of the closest Player
			for (Tile tile : Game.getMovableTiles()) {
				
				distance = p.distance(tile);
				
				// If the distance is better
				if (distance < bestDistance) {
					bestDistance = distance;
					closest = tile;
				}
				
			}
			
//			Game.sleep(1);
			Game.showMovableTiles(Game.currentPlayer);

			// Attack
			boolean alive = this.attackArround();
			
			if (alive == true) {
				((Pirate) Game.currentPlayer).move(closest.getCoordinates());
			} else {
			     
				Platform.runLater(() -> {
					System.out.println("refresh");
		     		GuiController.render();
					
					Game.pass();
				});
			}
			
		} else {

			// Attack
			boolean alive = this.attackArround();
			
			if (alive == true) {
				((Pirate) Game.currentPlayer).move(Game.getMovableTiles().get(0).getCoordinates());
			} else {
			     
				Platform.runLater(() -> {
					System.out.println("refresh");
		     		GuiController.render();
					
					Game.pass();
				});
			}		
		}
	     
		Platform.runLater(() -> {
    		GuiController.render();
    		Game.pass();
		});
		
	}

	/**
	 * Move the {@code Pirate} to a specific position
	 * @param pos {@code Point2D} The {@code Map} coordinates
	 */
	@Override
	public void move(Point2D pos) {	
		Map.clearActive();
		this.coordinates = pos;
		
		GuiController.render();
	}

}
