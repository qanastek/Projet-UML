/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.EntitiesColors;
import src.fr.univavignon.ceri.application.config.EntityWalkStep;
import src.fr.univavignon.ceri.application.models.items.weapons.Musket;

/**
 * @author Yanis Labrak
 *
 */
public class Filibuster extends Pirate {

	/**
	 * @param inventory
	 * @param color
	 * @param coordinates
	 * @param walkStep
	 */
	protected Filibuster(Point2D coordinates) {
		super(EntitiesColors.FILIBUSTER, coordinates, EntityWalkStep.FILIBUSTER);
		this.inventory.addItem(new Musket());
	}

}
