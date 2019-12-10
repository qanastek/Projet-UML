/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.config.EntitiesColors;
import src.fr.univavignon.ceri.application.config.EntityWalkStep;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;

/**
 * @author Yanis Labrak
 *
 */
public class Buccaneer extends Pirate {
	
	/**
	 * Constructor
	 * @param coordinates {@code Point2D} Starting coordinates
	 */
	public Buccaneer(Point2D coordinates) {
		super(Textures.BUCCANEER, coordinates, EntityWalkStep.BUCCANEER);
		this.inventory.addItem(new Machete());
	}
	
	/**
	 * Constructor without coordinates
	 */
	public Buccaneer() {
		super(Textures.BUCCANEER, EntityWalkStep.BUCCANEER);
		this.inventory.addItem(new Machete());
	}

}
