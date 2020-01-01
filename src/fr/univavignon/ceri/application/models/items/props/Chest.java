/**
 * 
 */
package src.fr.univavignon.ceri.application.models.items.props;

/**
 * @author Yanis Labrak
 *
 */
public class Chest extends Prop {
	
	private static Chest instance = null;

	/**
	 * Constructor
	 */
	private Chest() {
		super("Make you win the game when you find It !");
	}
	
	public static Chest getInstance() {
		if (Chest.instance == null) {
			Chest.instance = new Chest();
			return Chest.instance;
		} else {
			return Chest.instance;
		}
	}	

	/*
	 * When is used, end the game
	 */
	@Override
	public void use() {
		// TODO: Make the body of It
	}

}
