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
