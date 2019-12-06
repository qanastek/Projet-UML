/**
 * 
 */
package models.entities;

import config.EntitiesColors;
import config.EntityWalkStep;
import javafx.geometry.Point2D;
import models.Inventory;
import models.items.props.Prop;
import models.items.weapons.Musket;

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
