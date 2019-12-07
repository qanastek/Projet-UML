/**
 * 
 */
package models;

import java.util.HashSet;
import java.util.Set;

import models.items.Item;
import models.items.props.Prop;

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
	 * @return 
	 * @return the content
	 */
	public Set<Item> getContent() {
		return this.content;
	}
	
	/**
	 * 
	 */
	public void addItem(Item item) {
		this.content.add(item);
	}	

}
