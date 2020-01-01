/**
 * 
 */
package src.fr.univavignon.ceri.application.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import src.fr.univavignon.ceri.application.models.items.Item;

/**
 * @author Yanis Labrak
 *
 */
public class Inventory {
	
	private ArrayList<Item> content;
	
	/**
	 * Constructor
	 */
	public Inventory() {
		this.content = new ArrayList<Item>();
	}

	/**
	 * Getter for the content
	 * @return {@code Set<Item>} The content
	 */
	public ArrayList<Item> getContent() {
		return this.content;
	}
	
	/**
	 * Add a {@code Item} to the {@code Inventory}
	 */
	public void addItem(Item item) {
		this.content.add(item);
	}

	@Override
	public String toString() {
		
		String content = "(";
		
		for (int i = 0; i < this.content.size(); i++) {
			
			Item item = this.content.get(i);
			content += item.toString();
			
			if (i < this.content.size() - 1) {
				content += ",";
			}
		}
		
		content += ")";
		
		return content;
		
	}
}
