/**
 * 
 */
package src.fr.univavignon.ceri.application.models;

import java.util.HashSet;
import java.util.Set;

import src.fr.univavignon.ceri.application.models.items.Item;

/**
 * @author Yanis Labrak
 *
 */
public class Inventory {
	
	private Set<Item> content;
	
	/**
	 * Constructor
	 */
	public Inventory() {
		this.content = new HashSet<Item>();
	}

	/**
	 * Getter for the content
	 * @return {@code Set<Item>} The content
	 */
	public Set<Item> getContent() {
		return this.content;
	}
	
	/**
	 * Add a {@code Item} to the {@code Inventory}
	 */
	public void addItem(Item item) {
		this.content.add(item);
	}	

}
