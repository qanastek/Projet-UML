/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.EntitiesColors;
import src.fr.univavignon.ceri.application.config.EntityWalkStep;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;

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
