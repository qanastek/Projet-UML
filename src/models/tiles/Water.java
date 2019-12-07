/**
 * 
 */
package models.tiles;

import models.items.props.Prop;

/**
 * @author Yanis Labrak
 *
 */
public class Water extends Tile {
	
	/**
	 * Constructor
	 */
	public Water() {
		super("#aad3df", false, false, false, false);
	}
	
	/**
	 * Constructor
	 */
	public Water(Prop item) {
		super("#aad3df", false, false, false, false, item);
	}

}
