/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Inventory;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.tiles.Forest;
import src.fr.univavignon.ceri.application.models.tiles.Tile;
import src.fr.univavignon.ceri.application.models.tiles.Water;

/**
 * @author Yanis Labrak
 *
 */
public abstract class Entity {
	
	protected Inventory inventory;
	protected String color;
	protected String texture = Textures.ERROR;
	protected Point2D coordinates;
	protected int walkStep;

	/**
	 * Constructor
	 */
	protected Entity(String img, Point2D coordinates, int walkStep) {
		this.inventory = new Inventory();
		this.texture = img;
		this.coordinates = coordinates;
		this.walkStep = walkStep;
	}
	
	/**
	 * Constructor without coordinates
	 */
	protected Entity(String img, int walkStep) {
		this.inventory = new Inventory();
		this.texture = img;
		this.coordinates = new Point2D(0.0,0.0);
		this.walkStep = walkStep;
	}
	
	/**
	 * Move the player to a specific position
	 */
	public void move(double d, double e) {

//		Tile tile = Map.getTile(d,e);
//		
//		if (tile.getActive()) {
//			this.move(tile.getCoordinates());
//		}
	}
	
	/**
	 * Move the player to a specific position
	 */
	public void move(Point2D pos) {
		this.coordinates= pos; 
	}
	
	/**
	 * 
	 */
	public int distance(Tile tile) {
		
		if (EntityManager.checkHasNoEntity(tile.getCoordinates()) == false) {
			return Integer.MAX_VALUE;
		} else if (tile instanceof Water) {
			return Integer.MAX_VALUE;
		} else if (tile instanceof Forest && !tile.canGoOn()) {
			return Integer.MAX_VALUE;
		}
		
		int x1 = (int) this.coordinates.getX();
		int y1 = (int) this.coordinates.getY();
		
		int x2 = (int) tile.getCoordinates().getX();
		int y2 = (int) tile.getCoordinates().getY();
		
		int distance = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		
		if (distance < 0) {
			distance = -distance;
		}
				
		return distance;		
	}
	
	/**
	 * Kill the {@code Player}
	 */
	public void die() {
		// TODO: Make the body of it
	}
	
	/**
	 * Scan for the {@code Entities} around and attack the first one if It as one
	 * @return
	 * {@code False} if the {@code Player} lose
	 * <br>
	 * {@code True} if the {@code Player} won
	 */
	public Boolean attackArround() {
		return null;
	}

	/**
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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

	/**
	 * @return the walkStep
	 */
	public int getWalkStep() {
		return walkStep;
	}

	/**
	 * @param walkStep the walkStep to set
	 */
	public void setWalkStep(int walkStep) {
		this.walkStep = walkStep;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}
	
}
