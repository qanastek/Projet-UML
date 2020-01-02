package src.fr.univavignon.ceri.application.models.entities;

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
			((Pirate) Game.currentPlayer).move(closest.getCoordinates());
			
		} else {
			((Pirate) Game.currentPlayer).move(Game.getMovableTiles().get(0).getCoordinates());
		}
		
		Game.pass();
	}

	/**
	 * Move the {@code Pirate} to a specific position
	 * @param pos {@code Point2D} The {@code Map} coordinates
	 */
	@Override
	public void move(Point2D pos) {	
		Map.clearActive();
		this.coordinates = pos;
		// TODO: Attack
		GuiController.render();
	}

}
