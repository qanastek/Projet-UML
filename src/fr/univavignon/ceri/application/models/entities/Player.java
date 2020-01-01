/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;
import src.fr.univavignon.ceri.application.models.tiles.Tile;

/**
 * @author Yanis Labrak
 *
 */
public class Player extends Entity {
	
	private String name;

	/**
	 * @param color
	 * @param coordinates
	 * @param walkStep
	 */
	public Player(String name, Point2D coordinates, int walkStep) {
		super(Textures.PLAYER, coordinates, walkStep);
		this.name = name;
	}

	public Player(String name, int walkStep) {
		super(Textures.PLAYER, walkStep);
		this.name = name;
	}
	
	/**
	 * Pick the {@code Item} on the {@code Tile}
	 */
	public void pick() {
		// TODO: Make the body
	}
	
	/**
	 * Dug the {@code Tile} in a way to find the {@code Chest}
	 */
	public void dig() {
		// TODO: Make the body
	}

	/**
	 * Move the {@code Player} to a specific position
	 * @param pos {@code Point2D} The screen coordinates
	 */
	public void move(double d, double e) {

		Tile tile = Map.getTile(d,e);
		
		if (tile.getActive()) {

			// TODO: Attack()
			
			// Move
			this.move(tile.getCoordinates());

			// TODO: Collect()
			this.collect(tile);
			System.out.println("***** Inventory *****");
			System.out.println(this.inventory.toString());
		}
	}
	
	/**
	 * @param tile
	 */
	private void collect(Tile tile) {
		
		Item item = tile.contain;
		
		if (item != null && this.alreadyHave(item) == false) {
			this.inventory.addItem(tile.collect());
		}
	}
	
	/**
	 * Check if the {@code Player} already have the {@code Item} inside his {@code Inventory}
	 * @param item {@code Item}
	 * @return
	 * {@code True}: Already have the {@code Item}
	 * <br>
	 * {@code False}: Doesn't have the {@code Item}
	 */
	private boolean alreadyHave(Item item) {
		
		// Check if any item of the inventory have the same type
		for (Item i : this.inventory.getContent()) {
			
			String c1 = i.getClass().getSimpleName().toString();
			String c2 = item.getClass().getSimpleName().toString();
			
			if(c1.equals(c2)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * If the {@code Player} have a {@code Shovel}
	 * @return
	 * {@code True} Have one
	 * <br>
	 * {@code False} Doesn't have one
	 */
	public Boolean haveShovel() {
		// TODO: Make the body
		return true;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
