/**
 * 
 */
package models.tiles;

import models.items.props.Prop;

/**
 * @author Yanis Labrak
 *
 */
public class Sand extends Tile {

	/**
	 * Constructor
	 */
	public Sand() {
		super("#eef0d5", true, false, true, true);
	}
	
	/**
	 * Constructor
	 */
	public Sand(Prop item) {
		super("#eef0d5", true, false, true, true, item);
	}
	
}
