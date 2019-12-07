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
public abstract class Pirate extends Entity {

	/**
	 * @param inventory
	 * @param color
	 * @param coordinates
	 * @param walkStep
	 */
	protected Pirate(String color, Point2D coordinates, int walkStep) {
		super(color, coordinates, walkStep);
	}	

}
