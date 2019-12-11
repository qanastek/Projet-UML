package src.fr.univavignon.ceri.application.models.tiles;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.entities.Player;
import src.fr.univavignon.ceri.application.models.items.props.Prop;

/**
 * @author Yanis Labrak
 */
public abstract class Tile {
	
	protected String color;
	protected String texture = Textures.ERROR;
	protected Boolean movable;
	protected Boolean cutable;
	protected Boolean spawnable;
	protected Boolean active;
	protected Boolean macheteCanSpawn;
	protected Prop contain;
	protected Point2D coordinates;
	
	/**
	 * Full constructor
	 */
	protected Tile(String img, Boolean movable, Boolean cutable, Boolean spawnable, Boolean macheteCanSpawn, Prop item) {
		this.texture = img;
		this.movable = movable;
		this.cutable = cutable;
		this.spawnable = spawnable;
		this.active = false;
		this.macheteCanSpawn = macheteCanSpawn;
		this.contain = item;
	}
	
	/**
	 * Constructor without any {@code Item}
	 */
	protected Tile(String img, Boolean movable, Boolean cutable, Boolean spawnable, Boolean macheteCanSpawn) {
		this.texture = img;
		this.movable = movable;
		this.cutable = cutable;
		this.spawnable = spawnable;
		this.active = false;
		this.macheteCanSpawn = macheteCanSpawn;
		this.contain = null;
	}
	
	/**
	 * Check if the {@code Entity} can walk on the {@code Tile}
	 */
	public Boolean canGoOn() {
		if (this instanceof Forest) {
			if (((Player) Game.currentPlayer).haveMachete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * Check if the {@code Entity} can cut the {@code Tile}
	 */
	public Boolean canCut() {
		// TODO: Fill up the body
		return true;
	}
	
	/**
	 * Check if a {@code Entity} can spawn the {@code Tile}
	 */
	public Boolean canSpawn() {
		// TODO: Fill up the body
		return true;
	}
	
	/**
	 * Switch the {@code Tile} {@code active} status 
	 */
	public void toggleActive() {
		if (this.active == false) {
			this.active = true;
		} else {
			this.active = false;
		}
	}
	
	/**
	 * Return if the Tile contain the Canvas coordinates
	 */
	public boolean containCoordinate(Double x, Double y) {
		
		Double ratio = GuiController.canvasDimensions.getX() / Game.mapSize;
		
		if (x > this.coordinates.getX() + ratio &&
			x < this.coordinates.getX() &&
			y > this.coordinates.getY() + ratio &&
			y < this.coordinates.getY()
		) {
			return true;			
		}
		return false;
	}
	
	/**
	 * Change the {@code Tile} {@code active} status to {@code false}
	 */
	public void clearActive() {
		this.active = false;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the movable
	 */
	public Boolean getMovsetColorable() {
		return movable;
	}

	/**
	 * @param movable the movable to set
	 */
	public void setMovable(Boolean movable) {
		this.movable = movable;
	}

	/**
	 * @return the cutable
	 */
	public Boolean getCutable() {
		return cutable;
	}

	/**
	 * @param cutable the cutable to set
	 */
	public void setCutable(Boolean cutable) {
		this.cutable = cutable;
	}

	/**
	 * @return the spawnable
	 */
	public Boolean getSpawnable() {
		return spawnable;
	}

	/**
	 * @param spawnable the spawnable to set
	 */
	public void setSpawnable(Boolean spawnable) {
		this.spawnable = spawnable;
	}

	/**
	 * @return the actived
	 */
	public Boolean getActive() {
		return this.active;
	}

	/**
	 * @param actived the actived to set
	 */
	public void setActive(Boolean status) {
		this.active = status;
	}

	/**
	 * @return the contain
	 */
	public Prop getContain() {
		return contain;
	}

	/**
	 * @param contain the contain to set
	 */
	public void setContain(Prop contain) {
		this.contain = contain;
	}

	/**
	 * @return the macheteCanSpawn
	 */
	public Boolean getMacheteCanSpawn() {
		return macheteCanSpawn;
	}

	/**
	 * @param macheteCanSpawn the macheteCanSpawn to set
	 */
	public void setMacheteCanSpawn(Boolean macheteCanSpawn) {
		this.macheteCanSpawn = macheteCanSpawn;
	}

	/**texture
	 * @return the coordinates
	 */
	public Point2D getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Point2D coordinates) {
		this.coordinates = coordinates;
	}

	public String getTexture() {
		return this.texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}
	
}
