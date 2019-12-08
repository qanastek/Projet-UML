/**
 * 
 */
package src.fr.univavignon.ceri.application.models.items.weapons;

import src.fr.univavignon.ceri.application.config.WeaponsDiagonals;
import src.fr.univavignon.ceri.application.config.WeaponsKillingChance;
import src.fr.univavignon.ceri.application.config.WeaponsRanges;

/**
 * @author Yanis Labrak
 *
 */
public class Machete extends Weapon {
	
	/**
	 * Constructor
	 */
	public Machete() {
		super(
			WeaponsKillingChance.MACHETE,
			WeaponsDiagonals.MACHETE,
			WeaponsRanges.MACHETE
		);
	}

}
