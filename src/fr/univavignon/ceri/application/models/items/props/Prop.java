/**
 * 
 */
package src.fr.univavignon.ceri.application.models.items.props;

import src.fr.univavignon.ceri.application.models.items.Item;

/**
 * @author Yanis Labrak
 *
 */
public abstract class Prop implements Item {
	
	/*
	 * Name of the item
	 */
	protected String description;
	
	/**
	 * Constructor
	 */
	protected Prop(String description) {
		this.description = description;
	}
	
	/**
	 * Use the item
	 */
	public abstract void use();

	/**
	 * Getter for the description
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for the description
	 * @param The description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
