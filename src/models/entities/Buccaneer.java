/**
 * 
 */
package models.entities;

import config.EntitiesColors;
import config.EntityWalkStep;
import javafx.geometry.Point2D;
import models.items.weapons.Machete;

/**
 * @author Yanis Labrak
 *
 */
public class Buccaneer extends Pirate {
	
	/**
	 * Constructor
	 */
	public Buccaneer(Point2D coordinates) {
		super(EntitiesColors.BUCCANEER, coordinates, EntityWalkStep.BUCCANEER);
		this.inventory.addItem(new Machete());
	}

}
