/**
 * 
 */
package src.fr.univavignon.ceri.application.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Point2D;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.config.TilesDistribution;
import src.fr.univavignon.ceri.application.models.entities.Buccaneer;
import src.fr.univavignon.ceri.application.models.entities.Entity;
import src.fr.univavignon.ceri.application.models.entities.EntityManager;
import src.fr.univavignon.ceri.application.models.entities.Filibuster;
import src.fr.univavignon.ceri.application.models.entities.Pirate;
import src.fr.univavignon.ceri.application.models.tiles.Forest;
import src.fr.univavignon.ceri.application.models.tiles.Sand;
import src.fr.univavignon.ceri.application.models.tiles.Tile;
import src.fr.univavignon.ceri.application.models.tiles.Water;

/**
 * @author Yanis Labrak
 *
 */
public class Map {
	
	private static Map instance = null;
	public static Tile[][] matrix;
	
	/**
	 * Constructor
	 * @param mapSize {@code Integer} Size of the {@code Map}
	 */
	private Map(int mapSize) {				
		Map.matrix = new Tile[mapSize][mapSize];	
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
	
	/**
	 * Return a random position in the matrix which is not already taken
	 * @return {@code Point2D} The coordinates
	 */
	public Point2D getRandomPosition() {
		
		int x = (int)(Math.random() * (((Game.mapSize - 1) - 0) + 1)) + 0;
		int y = (int)(Math.random() * (((Game.mapSize - 1) - 0) + 1)) + 0;
		
		Point2D p = new Point2D(x,y);
		
		if (EntityManager.checkHasNoEntity(p) == true && Map.matrix[x][y].canSpawn()) {
			return p;
		} else {
			return this.getRandomPosition();
		}
		
	}
	
	/*
	 * Place all the {@code Tile}'s on the {@code Map}
	 */
	public static void generateTiles() {
		
		int tilesNbr = (Game.mapSize * Game.mapSize);
		
		List<Tile> tilesStack = new ArrayList<Tile>();

		Tile tile;
		
		for (int i = 0; i < tilesNbr; i++) {
			
			// 5% Water
			if (i < Math.ceil(tilesNbr * TilesDistribution.WATER)) {
				tile = new Water();
			}
			// 5% Forest
			else if (i < Math.ceil(tilesNbr * TilesDistribution.FOREST)) {
				tile = new Forest();
			}
			// Others are Sand
			else {
				tile = new Sand();				
			}
			
			tilesStack.add(tile);
		}
		
		Collections.shuffle(tilesStack);
		
		int indexTilesStack = 0;
		
		// Load the Tiles into the Map matrix
		for (int i = 0; i < Game.mapSize; i++) {
			
			for (int j = 0; j < Game.mapSize; j++) {
				
				if (indexTilesStack < tilesStack.size()) {
					
					Map.matrix[i][j] = tilesStack.get(indexTilesStack);
					Map.matrix[i][j].setCoordinates(new Point2D(i, j));
					
					indexTilesStack++;
				}
				
			}			
		}
	}
	
	/**
	 * Clear all the active {@code Tile}
	 */
	public static void clearActive() {
		
		for (Tile[] tiles : matrix) {
			for (Tile tile : tiles) {
				if (tile.getActive()) {
					tile.toggleActive();
				}
			}
		}
		
		GuiController.render();

	}

	@Override
	public String toString() {
		
		String matrix = "";
		String matrixPos = "";
		
		for (int i = 0; i < Game.mapSize; i++) {
			
			String line = "";
			String linePos = "";
			
			for (int j = 0; j < Game.mapSize; j++) {
				
				line += " " + Map.matrix[i][j] + " ";
				linePos += " (" + Map.matrix[i][j].getCoordinates().getX() + "," + Map.matrix[i][j].getCoordinates().getY() + ") ";
				
			}
			
			matrix += line + "\n";
			matrixPos += linePos + "\n";
			
		}
		
		return matrix + "\n" + matrixPos;
	}

}
