/**
 * 
 */
package src.fr.univavignon.ceri.application.models.items.weapons;

import src.fr.univavignon.ceri.application.models.items.Item;

/**
 * @author Yanis Labrak
 */
public abstract class Weapon implements Item {

	/**
	 * Chance to kill the {@code Pirate}
	 */
	protected int killChance;
	
	/**
	 * Does this weapons can hit on diagonals
	 * <br>
	 * {@code True}: Can
	 * <br>
	 * {@code False}: Cannot
	 */
	protected Boolean diagonals;
	
	/**
	 * The hit range of the {@code Weapon}
	 */
	protected int range;
	
	/**
	 * Constructor
	 */
	protected Weapon(int killChance, Boolean diagonals, int range) {
		this.killChance = killChance;
		this.diagonals = diagonals;
		this.range = range;
	}
	
	/**
	 * Getter for the killing chance
	 * @return the killChance
	 */
	public int getKillChance() {
		return killChance;
	}
	
	/**
	 * Setter for the killing chance
	 * @param killChance the killChance to set
	 */
	public void setKillChance(int killChance) {
		this.killChance = killChance;
	}

	/**
	 * Getter for the diagonals
	 * @return the diagonals
	 */
	public Boolean getDiagonals() {
		return diagonals;
	}

	/**
	 * Setter for the diagonals
	 * @param diagonals the diagonals to set
	 */
	public void setDiagonals(Boolean diagonals) {
		this.diagonals = diagonals;
	}

	/**
	 * Getter for the range
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * Setter for the range
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
