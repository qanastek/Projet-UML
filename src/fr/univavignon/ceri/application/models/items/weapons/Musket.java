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
public class Musket extends Weapon {
	
	/**
	 * Constructor
	 */
	public Musket() {
		super(
			WeaponsKillingChance.MUSKET,
			WeaponsDiagonals.MUSKET,
			WeaponsRanges.MUSKET
		);
	}

}
