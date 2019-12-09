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
	 * Constructor
	 * @param coordinates {@code Point2D} Starting position
	 */
	public Filibuster(Point2D coordinates) {
		super(EntitiesColors.FILIBUSTER, coordinates, EntityWalkStep.FILIBUSTER);
		this.inventory.addItem(new Musket());
	}

	/*
	 * Constructor without coordinates
	 */
	public Filibuster() {
		super(EntitiesColors.FILIBUSTER, EntityWalkStep.FILIBUSTER);
		this.inventory.addItem(new Musket());
	}

}
