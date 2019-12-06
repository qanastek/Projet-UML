/**
 * 
 */
package models.entities;

import javafx.geometry.Point2D;
import models.Inventory;

/**
 * @author Yanis Labrak
 *
 */
public abstract class Entity {
	
	protected Inventory inventory;
	protected String color;
	protected Point2D coordinates;
	protected int walkStep;

	/**
	 * Constructor
	 */
	protected Entity(String color, Point2D coordinates, int walkStep) {
		this.inventory = new Inventory();
		this.color = color;
		this.coordinates = coordinates;
		this.walkStep = walkStep;
	}
	
	/**
	 * Move the player to a specific position
	 */
	public void move(int x, int y) {
		// TODO: Make the body of it
	}
	
	/**
	 * Kill the {@code Player}
	 */
	public void die() {
		// TODO: Make the body of it
	}
	
	/**
	 * Scan for the {@code Entities} around and attack the first one if It as one
	 * @return
	 * {@code False} if the {@code Player} lose
	 * <br>
	 * {@code True} if the {@code Player} won
	 */
	public Boolean attackArround() {
		return null;
	}
}
