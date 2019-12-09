package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;

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

	protected Pirate(String color, int walkStep) {
		super(color, walkStep);
	}	

}
