/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;

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
	 * If the {@code Player} have a {@code Machete}
	 * @return
	 * {@code True} Have one
	 * <br>
	 * {@code False} Doesn't have one
	 */
	public Boolean haveMachete() {
		
		for (Item item: this.inventory.getContent()) {
			if (item instanceof Machete) {
				return true;
			}
		}
		
		return false;
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
