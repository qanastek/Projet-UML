package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

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
	protected Pirate(String img, Point2D coordinates, int walkStep) {
		super(img, coordinates, walkStep);
	}	

	protected Pirate(String img, int walkStep) {
		super(img, walkStep);
	}	

}
