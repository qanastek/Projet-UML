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
public class Forest extends Tile {
	
	/**
	 * Constructor
	 */
	public Forest() {
		super(Textures.FOREST, true, true, true, false);
	}
	
	/**
	 * Constructor
	 */
	public Forest(Prop item) {
		super(Textures.FOREST, true, true, true, false, item);
	}
	
	@Override
	public String toString() {
		return "Forest";
	}

}
