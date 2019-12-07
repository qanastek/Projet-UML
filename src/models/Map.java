/**
 * 
 */
package models;

import models.tiles.Tile;

/**
 * @author Yanis Labrak
 *
 */
public class Map {
	
	private static Map instance = null;
	public Tile[][] matrix;
	
	/**
	 * Constructor
	 * @param mapSize {@code Integer} Size of the {@code Map}
	 */
	private Map(int mapSize) {				
		this.matrix = new Tile[mapSize][mapSize];	
	}
	
	/**
	 * Access point and builder for the {@code Map}
	 * @return {@code Map} The instance
	 */
	public static Map getInstance(int mapSize) {
		if (Map.instance == null) {
			Map.instance = new Map(mapSize);
			return instance;
		} else {
			return instance;
		}
	}

}
