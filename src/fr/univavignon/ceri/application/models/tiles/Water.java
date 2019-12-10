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
public class Water extends Tile {
	
	/**
	 * Constructor
	 */
	public Water() {
		super(Textures.WATER, false, false, false, false);
	}
	
	/**
	 * Constructor
	 */
	public Water(Prop item) {
		super(Textures.WATER, false, false, false, false, item);
	}

	@Override
	public String toString() {
		return "Water";
	}
}
