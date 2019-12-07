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
public class Armor extends Weapon {

	/**
	 * Constructor
	 */
	public Armor() {
		super(
			WeaponsKillingChance.ARMOR,
			WeaponsDiagonals.ARMOR,
			WeaponsRanges.ARMOR
		);
	}
}
