/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.Textures;

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
	 * @return If the {@code Player} have a {@code Shovel}
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
