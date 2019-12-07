/**
 * 
 */
package models.items.weapons;

import config.WeaponsDiagonals;
import config.WeaponsKillingChance;
import config.WeaponsRanges;

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
