/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Inventory;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.items.weapons.Machete;
import src.fr.univavignon.ceri.application.models.items.weapons.Weapon;
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
	 * Move the {@code Entity} to a specific position
	 * @param pos {@code Point2D} The {@code Map} coordinates
	 */
	public void move(Point2D pos) {
		Map.clearActive();
		this.coordinates = pos; 
		GuiController.render();
	}
	
	/**
	 * Distance between the an {@code Entity} and a {@code Tile}
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
	 * Distance between the an {@code Entity} and a {@code Entity}
	 */
	public int distance(Entity entity) {
		
		Tile tile = Map.getTile(entity.coordinates);
		
//		System.out.println("Tile");
//		System.out.println(tile.getCoordinates());
		
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
	 * If the {@code Player} have a {@code Machete}
	 * @return
	 * {@code True} Have one
	 * <br>
	 * {@code False} Doesn't have one
	 */
	public Boolean haveMachete() {
		
		for (Item item: this.inventory.getContent()) {
			if (item instanceof Machete) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Scan for the {@code Entities} around and attack the first one if It as one
	 * @return
	 * {@code False} if the attacker lose
	 * <br>
	 * {@code True} if the attacker won
	 */
	public Boolean attackArround() {

		// Closest Entity
		Entity p;
		
		// If we are a Player
		if (this instanceof Player) {
			p = Game.closestPirate();			
		}
		// If we are a Pirate
		else {
			p = Game.closestPlayer();
		}
		
		int range = this.calculateRange() + 1;
		int killingChance = this.calculateKillingChance();
		boolean diags = this.canAttackOnDiag();
		
		System.out.println("pirate");
		System.out.println(p);
		
		System.out.println("range");
		System.out.println(range);
		
		System.out.println("killingChance");
		System.out.println(killingChance);
		
		// If no enemy is around the current player
		if (p == null) {
			return true;			
		}
		
		int distance = p.distance(Game.currentPlayer);	
		
		// If can touch it
		if (distance <= range) {
			
			int Min = 0;
			int Max = 100;
			int randomHit = Min + (int)(Math.random() * ((Max - Min) + 1));
			System.out.println("Random" + randomHit);
			
			// If hit the enemy
			if (0 <= randomHit && randomHit <= killingChance) {
				
				System.out.println(Game.currentPlayer + " won !");
				
				EntityManager.kill(p);
				
				return true;
				
			} else {
				
				System.out.println(Game.currentPlayer + " die !");

				EntityManager.kill(Game.currentPlayer);
				
				return false;
			}
		}
		else {
			return true;
		}
	}
	
	/**
	 * Calculate the killing chance of the attack for the {@code Entity}
	 * @return {@code Integer} The chance
	 */
	public int calculateKillingChance() {
		
		int chance = 0;
		
		for (Item item : this.inventory.getContent()) {
			if (item instanceof Weapon) {
				chance += ((Weapon) item).getKillChance();
			}
		}
		
		return chance;
	}

	/**
	 * Calculate the range of attack for the {@code Entity}
	 * @return {@code Integer} The range
	 */
	public int calculateRange() {
		
		int range = 0;
		
		for (Item item : this.inventory.getContent()) {
			if (item instanceof Weapon && ((Weapon) item).getRange() > range) {
				range = ((Weapon) item).getRange();
			}
		}
		
		return range;
	}
	
	/**
	 * Return if the {@code Entity} can attack on diagonals
	 * @return
	 * {@code True}: Can
	 * <br>
	 * {@code False}: Cannot
	 */
	public boolean canAttackOnDiag() {
		
		boolean diag = false;
		
		for (Item item : this.inventory.getContent()) {
			if (item instanceof Weapon && ((Weapon) item).getDiagonals() == true) {
				diag = true;
			}
		}
		
		return diag;
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
