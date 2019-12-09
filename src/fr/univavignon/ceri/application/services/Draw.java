/**
 * 
 */
package src.fr.univavignon.ceri.application.services;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.entities.Entity;
import src.fr.univavignon.ceri.application.models.entities.EntityManager;
import src.fr.univavignon.ceri.application.models.tiles.Tile;

/**
 * @author Yanis Labrak
 *
 */
public class Draw {
	
	/**
	 * Draw all the {@code Tile}'s on the {@code Gui}
	 */
	public static void drawTiles() {
		
		Double width = GuiController.canvasDimensions.getX();
		Double height = GuiController.canvasDimensions.getY();
		
		Double tileWidth = width / Game.mapSize;
		Double tileHeight = height / Game.mapSize;
		
		for (Tile[] xTiles : Map.matrix) {
			for (Tile tile : xTiles) {
				
				Point2D coordinates = tile.getCoordinates();
				
				Double xTilePos = tileWidth * coordinates.getX();
				Double yTilePos = tileHeight * coordinates.getY();
				
				GuiController.gc.setFill(
					Color.web(tile.getColor())
				);	
				
				GuiController.gc.fillRect(
					xTilePos,
					yTilePos,
					tileWidth,
					tileHeight
				);
				
			}		
		}		
		
	}
	
	/**
	 * Draw all the {@code Entities} on the {@code Gui}
	 */
	public static void drawEntities() {

		Double width = GuiController.canvasDimensions.getX();
		Double height = GuiController.canvasDimensions.getY();
		
		Double tileWidth = width / Game.mapSize;
		Double tileHeight = height / Game.mapSize;
		
		for (Entity entity : EntityManager.getEntities()) {
			
			System.out.println("Enemy load");
				
			Point2D coordinates = entity.getCoordinates();
			
			Double xTilePos = tileWidth * coordinates.getX();
			Double yTilePos = tileHeight * coordinates.getY();
			
			GuiController.gc.setFill(
				Color.web(entity.getColor())
			);	
			
			GuiController.gc.fillRect(
				xTilePos,
				yTilePos,
				tileWidth,
				tileHeight
			);	
		}

	}

}
