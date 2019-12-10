package src.fr.univavignon.ceri.application.config;

import javafx.scene.image.Image;
import src.fr.univavignon.ceri.application.services.Draw;

public final class Textures {

	public static final Image ERROR = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/sand.jpeg"));
	public static final Image SAND = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/sand.jpeg"));
	public static final Image FOREST = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/forest.jpeg"));
	public static final Image WATER = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/water.jpeg"));
	public static final Image PLAYER = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/player.jpeg"));
	public static final Image FILIBUSTER = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/filibuster.jpeg"));
	public static final Image BUCCANEER = new Image(Draw.class.getResourceAsStream("../ressources/assets/textures/buccaneer.jpeg"));
	
}
