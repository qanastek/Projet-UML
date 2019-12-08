/**
 * 
 */
package src.fr.univavignon.ceri.application.models.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanis Labrak
 *
 */
public class EntityManager {
	
	/*
	 * Contains all the Entity on the {@code Map}
	 */
	public static List<Entity> entities = new ArrayList<Entity>();
	
	/**
	 * Add an {@code Entity} to the {@code EntityManager}
	 * @param entity {@code Entity} The entity to insert into the {@code EntityManager}
	 */
	public static void addEntity(Entity entity) {
		EntityManager.entities.add(entity);
	}

}
