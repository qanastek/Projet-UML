/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

import src.fr.univavignon.ceri.application.models.Game;

/**
 * @author Yanis Labrak
 *
 */
public class EntityManager {
	
	/*
	 * Contains all the Entity on the {@code Map}
	 */
	public static List<Entity> entities;
	
	/*
	 * Instance of the EntityManager
	 */
	private static EntityManager instance = null;
	
	/**
	 * Constructor
	 */
	private EntityManager() {
		entities = new ArrayList<Entity>();
	}
	
	public static EntityManager getInstance() {
		if (EntityManager.instance == null) {
			EntityManager.instance = new EntityManager();
			return EntityManager.instance;
		} else {
			return EntityManager.instance;
		}		
	}
	
	/**
	 * Add an {@code Entity} to the {@code EntityManager}
	 * @param entity {@code Entity} The entity to insert into the {@code EntityManager}
	 */
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	/**
	 * @return the entities
	 */
	public static List<Entity> getEntities() {
		return entities;
	}
	
	/**
	 * Check if a entity is already on the {@code Tile}
	 * @return
	 * {@code True} Is empty
	 * <br>
	 * {@code False} Is not empty
	 */
	public static Boolean checkHasNoEntity(Point2D pos) {
		
		for (Entity entity : EntityManager.entities) {

			if (entity.coordinates.equals(pos)) {
				return false;
			}
		}
		
		return true;
	}

}
