/**
 * 
 */
package src.fr.univavignon.ceri.application.models.tiles;

import src.fr.univavignon.ceri.application.models.items.props.Prop;

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
