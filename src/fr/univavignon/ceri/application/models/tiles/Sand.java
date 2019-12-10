/**
 * 
 */
package src.fr.univavignon.ceri.application.models.tiles;

import src.fr.univavignon.ceri.application.config.Textures;
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
		super(Textures.SAND, true, false, true, true);
	}
	
	/**
	 * Constructor
	 */
	public Sand(Prop item) {
		super(Textures.SAND, true, false, true, true, item);
	}
	
	@Override
	public String toString() {
		return "Sand";
	}
	
}
