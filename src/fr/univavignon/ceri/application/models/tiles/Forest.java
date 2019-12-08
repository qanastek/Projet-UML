/**
 * 
 */
package src.fr.univavignon.ceri.application.models.tiles;

import src.fr.univavignon.ceri.application.models.items.props.Prop;

/**
 * @author Yanis Labrak
 *
 */
public class Forest extends Tile {
	
	/**
	 * Constructor
	 */
	public Forest() {
		super("#add19e", true, true, true, false);
	}
	
	/**
	 * Constructor
	 */
	public Forest(Prop item) {
		super("#add19e", true, true, true, false, item);
	}

}
